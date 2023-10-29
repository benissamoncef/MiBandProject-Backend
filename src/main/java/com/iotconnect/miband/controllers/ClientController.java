package com.iotconnect.miband.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;
import com.iotconnect.miband.service.IClientService;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	
	private IClientService serviceClient;

	public ClientController(IClientService sc) {
		this.serviceClient = sc;
	}

	@PostMapping("/saveClient")
	public ResponseEntity<String>  saveClient(@RequestBody Client p) {
		return new ResponseEntity<>(serviceClient.add(p) , HttpStatus.OK);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@PutMapping("/updateClient/{id}")
	public ResponseEntity<String> updateClient(@PathVariable("id") Long id, @RequestBody Client p) {
		 return new ResponseEntity<>(serviceClient.update(id, p), HttpStatus.OK);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/listClients")
	public List<Client> listClients() {
		return serviceClient.getAll();
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
		return new ResponseEntity<>("the client "+serviceClient.delete(id).getNom()+" is deleted successfully " , HttpStatus.OK);
	}
	
	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/getHeartbeatsByClient/{id}")
	public List<Heartbeat> getHeartbeatsByClient(@PathVariable Long id , @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "20") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		return serviceClient.getHeartbeatsByClient(id , pageNo, pageSize, sortBy);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/getClientById/{id}")
	public Client getClientById(@PathVariable Long id) {
		return serviceClient.getClientById(id);
	}

}
