package br.com.bliblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="Nome inválido.")
	private String nome;
	
    @CPF
	private String cpf;
	
	@Column(name="matrícula")
	@Pattern(regexp = "^[A][0-9]*$", message="Matrícula inválida.")
	private String matricula;
	
	@Email
	private String email;

}
