package com.xmtech.mcapi.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.xmtech.mcapi.entities.ClientEntity;

public class ClientDTO{
	
	private Long id;
	private String name;
	private String docNumber;
	private Instant birthDate;
	private AddressDTO address;
	private List<PhoneDTO> phoneList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<PhoneDTO> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneDTO> phoneList) {
		this.phoneList = phoneList;
	}

	public ClientEntity toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ClientEntity.class);
	}

}
