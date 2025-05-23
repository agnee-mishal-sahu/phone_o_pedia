package com.phoneopedia.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DesignDto {
	
    private List<String> color;
    private String build;
    private String weight; // in grams
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal thickness;
}
