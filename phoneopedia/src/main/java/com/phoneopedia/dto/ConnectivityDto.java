package com.phoneopedia.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ConnectivityDto {
	
	private List<ConnectivityNetwork> supportedNetworks;
    private Boolean infrared; //IR blaster
    private String wifiVersion;
    private BigDecimal bluetoothVersion;
    private Boolean nfc;
    private String usbType;
    private Boolean audioJack;
    private Boolean fmRadio;
    private Boolean gps;
    
    public String getLatestNetwork() {
    	
    	if(ObjectUtils.isNotEmpty(supportedNetworks)) {
    		Optional<Integer> max= supportedNetworks.stream().map(e->Integer.parseInt(e.getNetwork().substring(0,1))).max(Integer::compareTo);
    		if(max.isPresent()) {
    			return ConnectivityNetwork.fromLabel(String.valueOf(max.get())+"G").toString();
    		}
    	}
    	return null;
    }
}
