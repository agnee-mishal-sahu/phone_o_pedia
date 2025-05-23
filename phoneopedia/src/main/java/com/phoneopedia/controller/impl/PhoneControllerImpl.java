package com.phoneopedia.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoneopedia.common.constants.MessageConstants;
import com.phoneopedia.dto.PhoneRequestDto;
import com.phoneopedia.dto.PhoneResponseDto;
import com.phoneopedia.service.PhoneService;

@RestController
@RequestMapping("/phones")
public class PhoneControllerImpl extends PhoneOpediaController{
	
	@Autowired
	PhoneService phoneService;
	
	@PostMapping()
	public ResponseEntity<?> addPhone(@RequestBody PhoneRequestDto phoneRequest) {
		
		PhoneResponseDto response =phoneService.addPhone(phoneRequest);
		if(MessageConstants.APP_STATUS_FAILED.equals(response.getStatus())) {
			return new ResponseEntity<> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<> (response,HttpStatus.CREATED);

	}

}
