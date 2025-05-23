package com.phoneopedia.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.phoneopedia.common.constants.MessageConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GeneralInformationDto {

	@NotEmpty(message = "brand must not be empty")
	private String brand;
	@NotEmpty(message = "model must not be empty")
	private String model;
	@JsonFormat(pattern = MessageConstants.DATE_FORMAT)
	private String releaseDate;
	private BigDecimal price;
	private String waterResistanceRating;
	private boolean dualSim;
	private String description;
}
