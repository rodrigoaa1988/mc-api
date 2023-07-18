package com.xmtech.mcapi.entities;

import java.io.Serializable;
import java.util.Objects;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xmtech.mcapi.dtos.AddressDTO;
import com.xmtech.mcapi.dtos.PhoneDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class AddressEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String endereco;
	private String number;
	private String complemento;
	
	
	@OneToOne
	@MapsId
	private ClientEntity client;
	
	public AddressEntity() {
	}
	
	
	
	public AddressEntity(Long id, String cep, String uf, String cidade, String bairro, String endereco, String number,
			String complemento, ClientEntity client) {
		super();
		this.id = id;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.endereco = endereco;
		this.number = number;
		this.complemento = complemento;
		this.client = client;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public ClientEntity getClient() {
		return client;
	}



	public void setClient(ClientEntity client) {
		this.client = client;
	}



	public AddressDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AddressDTO.class);
	}

}
