package com.xmtech.mcapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xmtech.mcapi.dtos.ClientDTO;
import com.xmtech.mcapi.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("")
	public ResponseEntity<List<ClientDTO>> findAll(){
		return ResponseEntity.ok().body(clientService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(clientService.findById(id));
	}
	
	@GetMapping("/{client_information}/filter")
	public ResponseEntity<ClientDTO> findById(@PathVariable("client_information") String clientInformation, @RequestParam("type") String type){
		return ResponseEntity.ok().body(clientService.findByParam(type, clientInformation));
	}

}
