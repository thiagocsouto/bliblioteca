package br.com.bliblioteca.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

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
	
	@NotBlank
	@Size(max=400)
	private String resumo; 
	
	@Column(name="sumário")
	@NotBlank
	private String sumario;
	
	@Column(name="preço")
	@NotBlank
	private String preco;
	
	@Column(name="página")
	@NotBlank
	private String pagina;
	
	@NotBlank
	private String isbn;
	
	@Column(name="data_publicação")
	@FutureOrPresent
	private LocalDateTime dataDePublicacao;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name= "categoria_id")
//	private Categoria categoria;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name= "autor_id")
//	private Autor autor;

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 400) String resumo, @NotBlank String sumario,
			@NotBlank String preco, @NotBlank String pagina, @NotBlank String isbn,
			@FutureOrPresent LocalDateTime dataDePublicacao) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;  
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
	}

	
}
