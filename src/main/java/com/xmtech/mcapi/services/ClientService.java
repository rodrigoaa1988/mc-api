package com.xmtech.mcapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmtech.mcapi.dtos.ClientDTO;
import com.xmtech.mcapi.dtos.PhoneDTO;
import com.xmtech.mcapi.entities.ClientEntity;
import com.xmtech.mcapi.repositories.AddressRepository;
import com.xmtech.mcapi.repositories.ClientRepository;
import com.xmtech.mcapi.repositories.PhoneRepository;

@Service
public class ClientService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	public List<ClientDTO> findAll(){
		List<ClientEntity> list = clientRepository.findAll();
		return list.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ClientDTO findById(final Long id) {
		return clientRepository.findById(id).get().toDto();
	}
	
	public ClientDTO findByParam(final String type, final String clientInformation) {
		ClientDTO clientDto = new ClientDTO();
		if("documentNumber".equals(type)) {
			clientDto = clientRepository.findByDocumentNumber(clientInformation).toDto();
		}
		if ("phone".equals(type)) {
			clientDto = phoneRepository.findByPhone(clientInformation).getClient().toDto();
		}
		return clientDto;
	}

}
