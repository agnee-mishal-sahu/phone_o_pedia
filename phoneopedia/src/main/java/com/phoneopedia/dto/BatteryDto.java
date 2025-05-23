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
public class BatteryDto {
	
    private Integer capacity; // in mAh
    private Boolean fastCharging;
    private Boolean wirelessCharging;
}
