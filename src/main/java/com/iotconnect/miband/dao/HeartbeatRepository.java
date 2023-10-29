package com.iotconnect.miband.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

@Repository
public interface HeartbeatRepository  extends JpaRepository<Heartbeat, Long>{
	
	List<Heartbeat> findByClient(Client client , Pageable p);

}
