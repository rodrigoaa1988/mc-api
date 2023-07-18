package com.xmtech.mcapi.dtos;

import org.modelmapper.ModelMapper;

import com.xmtech.mcapi.entities.PhoneEntity;

public class PhoneDTO {
	
	private Long id;
    private String ddd;
    private String number;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public PhoneEntity toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PhoneEntity.class);
	}
    
    

}
