package br.com.bliblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String titulo;
	
	private String resumo; 
	
	@Column(name="preço")
	private String preco;
	
	@Column(name="página")
	private String pagina;
	
	private String Categoria;

	public Livro(String titulo, String resumo, String preco, String pagina, String categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.pagina = pagina;
		Categoria = categoria;
	}
	
}
