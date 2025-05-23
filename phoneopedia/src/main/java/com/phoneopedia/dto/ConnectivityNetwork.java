package com.phoneopedia.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConnectivityNetwork {
	TWO_G("2G"), THREE_G("3G"), FOUR_G("4G"), FIVE_G("5G");

	private final String label;

	ConnectivityNetwork(String label) {
		this.label = label;
	}

	@JsonValue
	public String getNetwork() {
		return label;
	}

	@JsonCreator
	public static ConnectivityNetwork fromLabel(String label) {
		for (ConnectivityNetwork type : values()) {
			if (type.label.equalsIgnoreCase(label)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown network type: " + label);
	}
}
