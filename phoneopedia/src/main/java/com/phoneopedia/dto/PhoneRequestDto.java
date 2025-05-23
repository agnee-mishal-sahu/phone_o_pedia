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
public class PhoneRequestDto {

	private GeneralInformationDto generalInformation;
	
	private PerformanceDto performance;
	
	private BatteryDto battery;
	
	private CameraDto camera;
	
	private ConnectivityDto connectivity;
	
	private DisplayDto display;
	
	private SecurityFeaturesDto securityFeatures;
	
	private DesignDto design;
}
