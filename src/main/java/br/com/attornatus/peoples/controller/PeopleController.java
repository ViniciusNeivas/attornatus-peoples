package br.com.attornatus.peoples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peoples.model.People;
import br.com.attornatus.peoples.repository.PeopleRepository;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PeopleRepository repository;

	@GetMapping
	public ResponseEntity<List<People>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
		
	}
}
