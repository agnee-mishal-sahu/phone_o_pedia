package com.phoneopedia.service;

import com.phoneopedia.dto.PhoneRequestDto;
import com.phoneopedia.dto.PhoneResponseDto;

public interface PhoneService {
	
	PhoneResponseDto addPhone(PhoneRequestDto phoneRequest);
}
