package com.iotconnect.miband.service;

import java.util.List;
import com.iotconnect.miband.models.Heartbeat;
import com.iotconnect.miband.models.HeartbeatClient;

public interface IHeartbeatService {


	Heartbeat update(Long id ,Heartbeat c);
	  
	Heartbeat add(Heartbeat c);
	  
	void delete(Long id);
	  
	Heartbeat getById(Long id);
	
	 List<Heartbeat> getAll();

	Heartbeat addHeartbeatClient(HeartbeatClient p);
	  
	 
}
