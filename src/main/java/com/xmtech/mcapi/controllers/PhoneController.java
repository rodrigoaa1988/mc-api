package com.xmtech.mcapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmtech.mcapi.models.Phone;

@RestController
@RequestMapping(value = "/phones")
public class PhoneController {
	
	@GetMapping
    public ResponseEntity<Phone> getAll(){
    	Phone phone = new Phone(1L, "11", "976827584");
    	return ResponseEntity.ok().body(phone);
    }
}
