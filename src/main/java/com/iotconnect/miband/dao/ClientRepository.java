package com.iotconnect.miband.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iotconnect.miband.models.Client;


@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{
	
	Client  findByMac(String mac);
}
