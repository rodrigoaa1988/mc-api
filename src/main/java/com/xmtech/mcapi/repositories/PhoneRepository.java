package com.xmtech.mcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xmtech.mcapi.entities.PhoneEntity;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long>{
	
	@Query(value = "SELECT * FROM TB_PHONE WHERE NUMBER = ?1", nativeQuery = true)
	PhoneEntity findByPhone(String number);

}
