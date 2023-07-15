package com.xmtech.mcapi.models;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String ddd;
    private String number;
    
    public Phone() {
    }

	public Phone(Long id, String ddd, String number) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
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
		Phone other = (Phone) obj;
		return Objects.equals(id, other.id);
	}
    
	
    
    
}
