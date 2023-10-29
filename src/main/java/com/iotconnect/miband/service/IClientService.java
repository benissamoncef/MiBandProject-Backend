package com.iotconnect.miband.service;

import java.util.List;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

public interface IClientService {

	String update(Long id, Client c);

	String add(Client c);

	Client delete(Long id);

	Client getByMac(String mac);

	Client getByHeartbeat(Long id);

	List<Client> getAll();

	List<Heartbeat> getHeartbeatsByClient(Long id ,Integer pageNo, Integer pageSize, String sortBy);

	Client getClientById(Long id);

}
