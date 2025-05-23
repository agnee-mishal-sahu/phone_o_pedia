package com.phoneopedia.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneopedia.common.constants.MessageConstants;
import com.phoneopedia.common.exceptions.BaseBusinessException;
import com.phoneopedia.common.utilites.ApplicationUtils;
import com.phoneopedia.common.utilites.JsonUtils;
import com.phoneopedia.dto.PhoneRequestDto;
import com.phoneopedia.dto.PhoneResponseDto;
import com.phoneopedia.entity.PhoneEntity;
import com.phoneopedia.repository.PhoneRepository;
import com.phoneopedia.service.PhoneService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public PhoneResponseDto addPhone(PhoneRequestDto phoneRequest) {
		log.info("Inside addPhone::");

		PhoneResponseDto phoneResponse = new PhoneResponseDto();
		PhoneEntity phoneEntity = new PhoneEntity();
		try {

			phoneEntity.setCorrelationId(ApplicationUtils.getRandomUUID());

			if (ObjectUtils.isNotEmpty(phoneRequest.getGeneralInformation())) {
				if (ObjectUtils.isEmpty(phoneRequest.getGeneralInformation().getBrand())
						|| ObjectUtils.isEmpty(phoneRequest.getGeneralInformation().getModel())) {
					throw new BaseBusinessException("Brand/Model cannot be empty");
				}
				phoneEntity.setBrand(phoneRequest.getGeneralInformation().getBrand());
				phoneEntity.setModel(phoneRequest.getGeneralInformation().getModel());
				phoneEntity.setPrice(phoneRequest.getGeneralInformation().getPrice());
				SimpleDateFormat sdf = new SimpleDateFormat(MessageConstants.DATE_FORMAT);
				Date releaseDate = sdf.parse(phoneRequest.getGeneralInformation().getReleaseDate());
				phoneEntity.setReleasedDate(releaseDate);
				phoneEntity.setDualSim(phoneRequest.getGeneralInformation().isDualSim());
			} else {
				throw new BaseBusinessException("GeneralInformation cannot be empty");
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getPerformance())) {
				phoneEntity.setOperatingSystem(phoneRequest.getPerformance().getOperatingSystem());
				phoneEntity.setProcessor(phoneRequest.getPerformance().getProcessor());
				phoneEntity.setRam(phoneRequest.getPerformance().getRam());
				phoneEntity.setStorage(phoneRequest.getPerformance().getStorage());
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getConnectivity())) {
				phoneEntity.setConnectivity(phoneRequest.getConnectivity().getLatestNetwork());
				phoneEntity.setBluetoothVersion(phoneRequest.getConnectivity().getBluetoothVersion());
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getBattery())) {
				phoneEntity.setBatteryCapacity(phoneRequest.getBattery().getCapacity());
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getDisplay())) {
				phoneEntity.setDisplaySize(phoneRequest.getDisplay().getSize());
				phoneEntity.setDisplayType(phoneRequest.getDisplay().getType());
				phoneEntity.setRefreshRate(phoneRequest.getDisplay().getRefreshRate());
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getCamera())
					&& ObjectUtils.isNotEmpty(phoneRequest.getCamera().getRearCameraSpecifications())
					&& ObjectUtils.isNotEmpty(phoneRequest.getCamera().getFrontCameraSpecifications())) {
				phoneEntity.setRearCameraResolution(
						phoneRequest.getCamera().getRearCameraSpecifications().getResolution());
				phoneEntity.setFrontCameraResolution(
						phoneRequest.getCamera().getFrontCameraSpecifications().getResolution());
				phoneEntity
						.setNumberOfCamera(phoneRequest.getCamera().getRearCameraSpecifications().getNumberOfLenses());
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getDesign())) {
				String color = "";
				for (String c : phoneRequest.getDesign().getColor()) {
					color = color.concat(c + ",");
				}
				phoneEntity.setColor(color.substring(0, color.length() - 1));
			}

			if (ObjectUtils.isNotEmpty(phoneRequest.getSecurityFeatures())) {
				phoneEntity.setFaceUnlock(phoneRequest.getSecurityFeatures().isFaceUnlock());
				phoneEntity.setFingerPrintSensor(phoneRequest.getSecurityFeatures().isFingerprintSensor());
			}

			phoneEntity.setSpecifications(ApplicationUtils.stringToBlob(JsonUtils.toJson(phoneRequest)));

			phoneEntity = this.phoneRepository.save(phoneEntity);

			log.info("Phone saved with id: " + phoneEntity.getId() + " and correlationId: "
					+ phoneEntity.getCorrelationId());

			phoneResponse.setStatus(MessageConstants.APP_STATUS_SUCCESS);
			phoneResponse.setCorrelationId(phoneEntity.getCorrelationId());
			phoneResponse.setModel(phoneEntity.getBrand() + " | " + phoneEntity.getModel() + " | RAM: "
					+ phoneEntity.getRam() + " | Storage: " + phoneEntity.getStorage());
			return phoneResponse;
		} catch (Exception e) {
			log.info("!!!Error at addPhone!!! " + ExceptionUtils.getStackTrace(e));
			String message = e.getClass().getSimpleName() + ": " + e.getMessage();
			phoneResponse.setFailedReason(message);
			phoneResponse.setStatus(MessageConstants.APP_STATUS_FAILED);
		}

		return phoneResponse;
	}

}
