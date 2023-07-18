package com.xmtech.mcapi.entities;

import java.io.Serializable;
import java.util.Objects;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xmtech.mcapi.dtos.PhoneDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_phone")
public class PhoneEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String ddd;
    private String number;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
    
    public PhoneEntity() {
    }

	public PhoneEntity(Long id, String ddd, String number, ClientEntity client) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.client = client;
	}

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

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneEntity other = (PhoneEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	public PhoneDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PhoneDTO.class);
	}

}
