package br.com.bliblioteca.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="livro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="título")
	@NotBlank
	private String titulo;
	
	@Column(name="ano")
	private Integer ano;
	
	@NotBlank
	@Size(max=300)
	@Column(name="resumo")
	private String resumo; 
	
	@Column(name="sumário")
	@NotBlank
	private String sumario;
	
	@Column(name="observação")
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$|", message="Nome inválido.")
	private String observação;
	
	@Column(name="página")
	@NotBlank
	private String pagina;
	
	@NotBlank
	private String isbn;
	
	@Column(name="data_publicação")
	@DateTimeFormat( pattern = "dd/MM/yyyy" )
	private Date dataPublicacao;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name= "categoria_id")
//	private Categoria categoria;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name= "autor_id")
//	private Autor autor;

	
}
