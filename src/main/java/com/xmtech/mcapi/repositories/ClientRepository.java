package com.xmtech.mcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xmtech.mcapi.entities.ClientEntity;
import com.xmtech.mcapi.entities.PhoneEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{
	
	@Query(value = "SELECT * FROM TB_CLIENT WHERE DOC_NUMBER = ?1", nativeQuery = true)
	ClientEntity findByDocumentNumber(String documentNumber);

}
