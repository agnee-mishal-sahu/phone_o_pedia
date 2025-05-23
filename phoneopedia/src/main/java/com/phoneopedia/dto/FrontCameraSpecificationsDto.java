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
public class FrontCameraSpecificationsDto {

	private Integer resolution; // in MP
    private String aperture;
    private Boolean autofocus;
    private String flash; // screen flash or LED
    private String fieldOfView; // e.g., 90° wide-angle
}
