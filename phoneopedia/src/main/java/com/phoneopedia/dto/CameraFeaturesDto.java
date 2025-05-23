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
public class CameraFeaturesDto {
	
	private Boolean aiSceneDetection;
    private Boolean nightMode;
    private Boolean proMode; // Manual Mode
    private Boolean panorama;
    private Boolean hdr;
    private Boolean portraitMode; // Bokeh
    private Boolean beautyMode;
    private Boolean arStickers; // Filters
}
