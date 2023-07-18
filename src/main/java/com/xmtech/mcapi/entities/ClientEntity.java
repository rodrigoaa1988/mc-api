package com.xmtech.mcapi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmtech.mcapi.dtos.ClientDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class ClientEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String docNumber;
	private Instant birthDate;
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	private AddressEntity address;
	
	@OneToMany(mappedBy = "client")
	private List<PhoneEntity> phoneList = new ArrayList<>();
	
	public ClientEntity() {
	}

	public ClientEntity(Long id, String name, String docNumber, Instant birthDate, AddressEntity address,
			List<PhoneEntity> phoneList) {
		super();
		this.id = id;
		this.name = name;
		this.docNumber = docNumber;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneList = phoneList;
	}

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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<PhoneEntity> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneEntity> phoneList) {
		this.phoneList = phoneList;
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
		ClientEntity other = (ClientEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	public ClientDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		ClientDTO clientDTO = modelMapper.map(this, ClientDTO.class);
		return clientDTO;
	}

}
