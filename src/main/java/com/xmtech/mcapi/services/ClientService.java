package com.xmtech.mcapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmtech.mcapi.dtos.ClientDTO;
import com.xmtech.mcapi.dtos.PhoneDTO;
import com.xmtech.mcapi.entities.AddressEntity;
import com.xmtech.mcapi.entities.ClientEntity;
import com.xmtech.mcapi.entities.PhoneEntity;
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
	
	public ClientDTO save(ClientDTO clientDto) {
		List<PhoneDTO> phoneDtoList = clientDto.getPhoneList();
		List<PhoneEntity> phoneEntityList = new ArrayList<>();
		for(PhoneDTO phoneIndex : phoneDtoList) {
			phoneEntityList.add(phoneIndex.toEntity());
		}
		clientDto.setPhoneList(null);
		AddressEntity addressEntity = clientDto.getAddress().toEntity();
		clientDto.setAddress(null);
		ClientEntity clientEntity = clientRepository.save(clientDto.toEntity());
		for(PhoneEntity phoneIndex: phoneEntityList) {
			phoneIndex.setClient(clientEntity);
		}
		clientEntity.setPhoneList(phoneRepository.saveAll(phoneEntityList));
		clientEntity.setAddress(addressEntity);
		addressEntity.setClient(clientEntity);
		clientEntity = clientRepository.save(clientEntity);
		return clientEntity.toDto();
	}
	
	public ClientDTO update(final Long id, final ClientDTO client) {
		ClientEntity clientEntity = new ClientEntity();
		Optional<ClientEntity> clientOptional = clientRepository.findById(id);
		if(clientOptional.isPresent()) {
			clientEntity.setId(id);
			clientEntity.setDocNumber(client.getDocNumber());
			clientEntity.setName(client.getName());
			clientEntity.setBirthDate(client.getBirthDate());
			
			for(PhoneDTO phoneIndex : client.getPhoneList()) {
				Optional<PhoneEntity> phoneOptional = phoneRepository.findById(phoneIndex.getId());
				if(phoneOptional.isPresent()) {
					PhoneEntity phoneEntity = phoneIndex.toEntity();
					phoneEntity.setClient(clientEntity);
					phoneRepository.save(phoneEntity);
				}
			}	
			Optional<AddressEntity> addressOptional = addressRepository.findById(client.getAddress().getId());
			if(addressOptional.isPresent()) {
				AddressEntity addressEntity = client.getAddress().toEntity();
				addressEntity.setClient(clientEntity);
				clientEntity.setAddress(addressEntity);
			}
		}
		return clientRepository.save(clientEntity).toDto();
	}
	
	public void delete(final Long id) {
		ClientEntity clientEntity = new ClientEntity();
		Optional<ClientEntity> clientOptional = clientRepository.findById(id);
		if(clientOptional.isPresent()) {
			clientEntity = clientOptional.get();
			for(PhoneEntity phoneIndex : clientEntity.getPhoneList()) {
				Optional<PhoneEntity> phoneOptional = phoneRepository.findById(phoneIndex.getId());
				if(phoneOptional.isPresent()) {
					phoneRepository.deleteById(phoneIndex.getId());
				}
			}
			Optional<AddressEntity> addressOptional = addressRepository.findById(clientEntity.getAddress().getId());
			if(addressOptional.isPresent()) {
				addressRepository.deleteById(clientEntity.getAddress().getId());
			}
			clientRepository.deleteById(id);
		}
		
		
	}

}
