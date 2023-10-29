package com.iotconnect.miband.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.iotconnect.miband.dao.HeartbeatRepository;
import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;
import com.iotconnect.miband.models.HeartbeatClient;

@Transactional
@Service
public class HeartbeatServiceImpl implements IHeartbeatService {
	
	private HeartbeatRepository  heartbeatRepository;
	
	private IClientService clientService;
	
	public HeartbeatServiceImpl(HeartbeatRepository hbr , IClientService cs) {
		this.heartbeatRepository = hbr;
		this.clientService = cs;
	}

	@Override
	@ExceptionHandler({Exception.class})
	public Heartbeat update(Long id, Heartbeat c) {
		Heartbeat h = this.heartbeatRepository.findById(id).get();
			h.setData1(c.getData1());
			h.setData2(c.getData2());
			h.setData3(c.getData3());
			h.setData4(c.getData4());
			h.setDate_prelevement(c.getDate_prelevement());
			return this.heartbeatRepository.save(h);			
	}

	@Override
	public Heartbeat add(Heartbeat c) {
		return this.heartbeatRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		Heartbeat hb = this.heartbeatRepository.findById(id).get();
		 this.heartbeatRepository.delete(hb);
	}

	@Override
	public Heartbeat getById(Long id) {
		return	this.heartbeatRepository.findById(id).get();
	}

	@Override
	public List<Heartbeat> getAll() {
		return heartbeatRepository.findAll();
	}

	@Override
	public Heartbeat addHeartbeatClient(HeartbeatClient p) {
		if(p.getMac() != null && !p.getMac().strip().isBlank() && p.getData1() != null  && !p.getData1().strip().isBlank()) {
			System.out.println("Mac : " + p.getMac());
			Client c = clientService.getByMac(p.getMac());
			if(c != null ) {
			System.out.println("Client : " + c);
			Heartbeat h = new Heartbeat();
			h.setData1(p.getData1());
			h.setData2(p.getData2());
			h.setData3(p.getData3());
			h.setData4(p.getData4());
			h.setDate_prelevement(p.getDate_prelevement());
			h = add(h);
			c.addHeartbeat(h);
			clientService.add(c);
			return h;
			}
		}
		System.out.println("Null ");
		return null;
	}

}
