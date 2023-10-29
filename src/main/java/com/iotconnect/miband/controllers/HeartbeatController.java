package com.iotconnect.miband.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iotconnect.miband.models.Heartbeat;
import com.iotconnect.miband.models.HeartbeatClient;
import com.iotconnect.miband.service.IHeartbeatService;

@CrossOrigin(origins = "*")
@RestController
public class HeartbeatController {

	private IHeartbeatService heartbeatService ;
	
	public HeartbeatController(IHeartbeatService hbs) {
		this.heartbeatService = hbs;
	}
	
//	@PostMapping("/saveHeartbeat")
//	public Heartbeat saveHeartbeat(@RequestBody Heartbeat p) {
//		return heartbeatService.add(p);
//	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	@PostMapping("/addHeartbeatClient")
	public Heartbeat addHeartbeatClient(@RequestBody HeartbeatClient p) {
		return heartbeatService.addHeartbeatClient(p);
	}
	
	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@PutMapping("/updateHeartbeat/{id}")
	public Heartbeat updateHeartbeat(@PathVariable("id") Long id, @RequestBody Heartbeat p) {
		return heartbeatService.update(id, p);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/listHeartbeats")
	public List<Heartbeat> listHeartbeats() {
		return heartbeatService.getAll();
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@DeleteMapping("/deleteHeartbeat/{id}")
	public void deleteHeartbeat(@PathVariable("id") Long id) {
		   heartbeatService.delete(id);
	}

}
