package br.com.attornatus.peoples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	@ManyToOne
	@JoinColumn(name = "id_people", foreignKey = @ForeignKey(name = "fk_endereco_people"))
	@JsonBackReference
	@JsonIgnoreProperties("listEndereco")
	private People people;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero" )
	private Long numero;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "enderecoPrimario")
	private boolean enderecoPrimario;
	
	public Endereco() {

	}

	public Endereco (Long idEndereco, String lograoduro, Long numero, String cep, String cidade, People people ) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = lograoduro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.people = people;		
	}
	
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public boolean isEnderecoPrimario() {
		return enderecoPrimario;
	}

	public void setEnderecoPrimario(boolean enderecoPrimario) {
		this.enderecoPrimario = enderecoPrimario;
	}

}