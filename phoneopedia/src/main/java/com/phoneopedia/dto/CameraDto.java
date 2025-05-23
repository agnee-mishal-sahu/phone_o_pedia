package com.phoneopedia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CameraDto {

	private RearCameraSpecificationsDto rearCameraSpecifications;
	private FrontCameraSpecificationsDto frontCameraSpecifications;
	private VideoCapabilitiesDto videoCapabilities;
	private CameraFeaturesDto cameraFeatures;

}
