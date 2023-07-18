package com.xmtech.mcapi.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xmtech.mcapi.entities.AddressEntity;
import com.xmtech.mcapi.entities.ClientEntity;
import com.xmtech.mcapi.entities.PhoneEntity;
import com.xmtech.mcapi.repositories.AddressRepository;
import com.xmtech.mcapi.repositories.ClientRepository;
import com.xmtech.mcapi.repositories.PhoneRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Override
	public void run(String... args) throws Exception {
			
		
		
		ClientEntity c1 = new ClientEntity(null,"Rodrigo dos Anjos Almeida", "35389724860", Instant.parse("1988-03-19T00:00:00Z"), null, null);
		ClientEntity c2 = new ClientEntity(null,"Nubia Carla Sales", "33355562480", Instant.parse("1984-06-13T00:00:00Z"), null, null);
		ClientEntity c3 = new ClientEntity(null,"Jairivaldo dos Anjos Almeida", "35898512606", Instant.parse("1984-07-21T00:00:00Z"), null, null);
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Quando for salvar o phone, pesquisar pelo cliente
		PhoneEntity phone1 = new PhoneEntity(null, "11", "976827584", c1);
		PhoneEntity phone2 = new PhoneEntity(null, "11", "952308497", c2);
		PhoneEntity phone3 = new PhoneEntity(null, "11", "45521349", c1);
		PhoneEntity phone4 = new PhoneEntity(null, "11", "976809583", c3);
		
		phoneRepository.saveAll(Arrays.asList(phone1, phone2, phone3, phone4));
		
		AddressEntity address1 = new AddressEntity(null, "06449160", "SP", "Barueri", "Parque Viana", "Rua Cerejeira", "224", "", c1);
		AddressEntity address2 = new AddressEntity(null, "0132168", "SP", "Osasco", "Jardim Munhoz Jr", "Rua Pardinho", "41", "", c2);
		AddressEntity address3 = new AddressEntity(null, "06449160", "SP", "Barueri", "Parque Viana", "Rua Cerejeira", "224", "", c3);
		c1.setAddress(address1);
		c2.setAddress(address2);
		c3.setAddress(address3);
		//Quando for salvar um endereço - Colocar o cliente no endereço e salvar o cliente novamente
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
	

}
