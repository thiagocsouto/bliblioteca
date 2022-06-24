package br.com.bliblioteca.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="autor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "nome em formato inválido.")
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(max = 400) 
	@Column(name="descrição")
	private String descricao;
//	
//	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Livro> livros;

	public Autor(@NotBlank(message = "nome em formato inválido.") String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	
	
} 
