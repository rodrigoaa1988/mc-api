package com.xmtech.mcapi.dtos;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xmtech.mcapi.entities.AddressEntity;
import com.xmtech.mcapi.entities.ClientEntity;

public class AddressDTO {
	
	private Long id;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String endereco;
	private String number;
	private String complemento;
	@JsonIgnore
	private ClientEntity client;
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
	
	public AddressEntity toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AddressEntity.class);
	}

}
