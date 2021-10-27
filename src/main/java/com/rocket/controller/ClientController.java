package com.rocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.model.Client;
import com.rocket.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listar(){
		
		return clientRepository.findAll();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client adicionar(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	

}

