package br.com.attornatus.peoples.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.attornatus.peoples.model.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

	public List <People> findAllByNomeContainingIgnoreCase(String nome); 
	
}

