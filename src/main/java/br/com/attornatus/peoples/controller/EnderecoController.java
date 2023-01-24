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

import br.com.attornatus.peoples.model.Endereco;
import br.com.attornatus.peoples.service.EnderecoService;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco save(@RequestBody Endereco endereco) {
		return enderecoService.saveEndereco(endereco);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Endereco> listEndereco(){
		return enderecoService.listEndereco();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Endereco findEnderecoById (@PathVariable("id") Long id) {
		return enderecoService.findEnderecoById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeEndereco(@PathVariable Long id) {
		 enderecoService.findEnderecoById(id)
				.map(endereco -> {
					enderecoService.removeEnderecoById(endereco.getIdEndereco());
					return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));				
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateEndereco (@PathVariable("id") Long id, @RequestBody Endereco endereco){
		enderecoService.findEnderecoById(id)
		.map(enderecoBase ->{
			modelMapper.map(endereco, enderecoBase);
			enderecoService.saveEndereco(endereco);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
	}
}