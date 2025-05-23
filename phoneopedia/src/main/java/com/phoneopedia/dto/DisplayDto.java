package com.phoneopedia.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DisplayDto {
	
    private BigDecimal size; // in inches
    private String type; // e.g., AMOLED
    private String resolution; // e.g., QHD+
    private Integer refreshRate; // in Hz
    private Integer brightness; //e.g., 1300 nits
    private String displayProtection; //e.g., Gorilla Glass Victus 2
    private Boolean curved;
}
