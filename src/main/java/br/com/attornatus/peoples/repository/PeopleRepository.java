package br.com.attornatus.peoples.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import br.com.attornatus.peoples.model.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
	
}

