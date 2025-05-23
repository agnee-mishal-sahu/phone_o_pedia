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
public class PerformanceDto {
	
	private String operatingSystem;
    private String processor;
    private String cpuArchitecture; //Octa-core, ARM Cortex-X4
    private Integer ram; // in GB
    private String ramType; //e.g., LPDDR5X
    private Integer storage; 
    private String storageType;//e.g., UFS 3.1, UFS 4.0
    private String storageUnit; //GB,TB
    private String coolingSystem;
    private String gamingFeatures;
}
