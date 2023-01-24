package br.com.attornatus.peoples.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.attornatus.peoples.model.Endereco;
import br.com.attornatus.peoples.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public List<Endereco> listEndereco(){
		return enderecoRepository.findAll();
	}

	public Optional<Endereco> findEnderecoById(Long id){
		return enderecoRepository.findById(id);
	}
	
	public void removeEnderecoById(Long id) {
		enderecoRepository.deleteById(id);
	}
	
	public void setEnderecoPrimario(Endereco endereco) {
		Endereco enderecoPrimario = enderecoRepository.findByEnderecoPrimario(true);
		
		if(enderecoPrimario != null) {
			enderecoPrimario.setEnderecoPrimario(false);
			enderecoRepository.save(enderecoPrimario);
		}else {
			endereco.setEnderecoPrimario(true);
			enderecoRepository.save(endereco);
		}
	}
}