package br.com.attornatus.peoples.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.attornatus.peoples.model.People;
import br.com.attornatus.peoples.repository.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	public People savePeople(People people) {
		return peopleRepository.save(people);
	}
	
	public List<People> listPeople() {
		return peopleRepository.findAll();
	}
	
	public Optional<People> findPeopleById (Long id){
		return peopleRepository.findById(id);
	}
	
	public List<People> findPeopleByNome (String nome){
		return peopleRepository.findAllByNomeContainingIgnoreCase(nome);
	}
	
	public void removePeopleById(Long id) {
		peopleRepository.deleteById(id);
	}
}