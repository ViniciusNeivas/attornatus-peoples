package br.com.attornatus.peoples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.attornatus.peoples.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findByEnderecoPrimario(boolean enderecoPrimario);
}
