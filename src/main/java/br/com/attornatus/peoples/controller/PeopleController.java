package br.com.attornatus.peoples.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.attornatus.peoples.model.People;
import br.com.attornatus.peoples.service.PeopleService;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public People save(@RequestBody People people) {
		return peopleService.savePeople(people);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<People> listPeople(){
		return peopleService.listPeople();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public People findPeopleById (@PathVariable("id") Long id){
		return peopleService.findPeopleById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
	}
	
	@GetMapping("/nome/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public List<People> getByName(@PathVariable String nome){
		return peopleService.findPeopleByNome(nome);				
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removePeople(@PathVariable Long id) {
		peopleService.findPeopleById(id)
		.map(people -> {
			peopleService.removePeopleById(id);
			return Void.TYPE;
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePeople (@PathVariable("id") Long id, @RequestBody People people) {
		peopleService.findPeopleById(id)
		.map(peopleBase -> {
			modelMapper.map(people, peopleBase);
			peopleService.savePeople(people);
			return Void.TYPE;
			}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
	}
}