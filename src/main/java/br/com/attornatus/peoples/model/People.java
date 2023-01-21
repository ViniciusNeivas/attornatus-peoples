package br.com.attornatus.peoples.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_peoples")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "DataDeNascimento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
	

	public People() {

	}

	public People(Long id, String nome, LocalDate dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

//	public People(Long id, String nome, Date dataDeNascimento, Endereco endereco) {
//		this.id = id;
//		this.nome = nome;
//		this.dataDeNascimento = dataDeNascimento;
//		this.endereco = endereco;
//				
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNone(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}



	
	
	
	
}
