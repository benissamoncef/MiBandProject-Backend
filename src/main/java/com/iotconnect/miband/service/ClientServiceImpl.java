package com.iotconnect.miband.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iotconnect.miband.dao.ClientRepository;
import com.iotconnect.miband.dao.HeartbeatRepository;
import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

@Transactional
@Service
public class ClientServiceImpl implements IClientService{
	
	private ClientRepository  clientRepository;
	private HeartbeatRepository heartbeatRepository;
	
	public ClientServiceImpl(ClientRepository cr , HeartbeatRepository hbr) {
		this.clientRepository = cr;
		this.heartbeatRepository = hbr;
	}

	@Override
	public String update(Long id, Client c) {
		String message = null;
		if(c.getMac() != null) {
			Client newClient = getByMac(c.getMac());
			Client oldClient =  clientRepository.findById(id).orElse(null);;
		    if(oldClient != null && oldClient.equals(newClient)) {
		    	oldClient.setNom(c.getNom());
		    	oldClient.setPrenom(c.getPrenom());	
		    	oldClient.setAdresse(c.getAdresse());
		    	oldClient.setMail(c.getMail());
		    	oldClient.setTel(c.getTel());	
		   		oldClient.setMac(c.getMac());
                clientRepository.save(oldClient);
                message = "the client "+c.getNom()+" is updated successfully ";
		    }else {
		    	message = "Mac address already used";		    	
		    }
		}else{
			message = "Mac address is missing";
		}
		return message;		
	}

	@Override
	public String add(Client c) {
		String message = null;
		if(c.getMac() != null) {
			Client old = getByMac(c.getMac());
		    if(old != null) {
		    	message = "Mac address already used";
		    }else {
		    	 clientRepository.save(c);
		    	 message = "the client "+c.getNom()+" is added successfully ";
		    }
		}else{
			message = "Mac address is missing";
		}
		return message;		
	}

	@Override
	public Client delete(Long id) {
		Client old = clientRepository.findById(id).orElse(null);
	    clientRepository.delete(old);
	    return old;
	}

	@Override
	public Client getByMac(String mac) {
		return clientRepository.findByMac(mac);
	}

	@Override
	public Client getByHeartbeat(Long id) {
		return null;
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public List<Heartbeat> getHeartbeatsByClient(Long id , Integer pageNo, Integer pageSize, String sortBy) {
		if(id != null) {
			Client c = clientRepository.findById(id).orElse(null);
			if(c != null) {
				 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
				return heartbeatRepository.findByClient(c, paging);
			}
		}
		return null;
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

}
