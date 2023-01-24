package br.com.attornatus.peoples.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_peoples")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_people")
	private Long id;
	
	@NotBlank(message = "O campo nome é obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 3 e no máximo 100 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_de_nascimento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name= "id_people", foreignKey = @ForeignKey(name = "fk_endereco_people"))
	@JsonManagedReference
	@JsonIgnoreProperties("listEndereco")
	private List<Endereco> listEndereco = new ArrayList<>();
	
	public void addEndereco(Endereco endereco) {
		listEndereco.add(endereco);
	}
	
	public void removeEndereco (Endereco endereco) {
		listEndereco.remove(endereco);	
	}
	
	public People() {

	}

	public People(Long id, String nome, LocalDate dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

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

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}
}