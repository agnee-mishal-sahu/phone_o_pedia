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
public class VideoCapabilitiesDto {
	
	 private String videoResolution; // e.g., 4K@60fps, 8K@30fps
     private String slowMotion; // e.g., 960fps
     private Boolean hdrVideo;
     private Boolean videoStabilization; // OIS/EIS
     private Boolean cinematicMode; // Portrait Video
     private Boolean audioZoom; // Directional Audio
}
