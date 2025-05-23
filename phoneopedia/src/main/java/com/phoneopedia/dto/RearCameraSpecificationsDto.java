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
public class RearCameraSpecificationsDto {
	
	 private Integer resolution; // in MP
     private Integer numberOfLenses;
     private String lensTypes; // e.g., Wide, Ultra-Wide, Telephoto
     private String aperture; // e.g., f/1.8
     private Integer opticalZoom; // e.g., 3x
     private Integer digitalZoom; // e.g., up to 100x
     private Boolean opticalImageStabilization;
     private Boolean electronicImageStabilization;
     private String sensorSize; // e.g., 1/1.56”
     private String pixelSize; // e.g., 1.4µm
     private String autofocusType; // e.g., PDAF, Laser AF
     private String flashType; // e.g., Dual-LED, Quad-LED
}
