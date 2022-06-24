package br.com.bliblioteca.DTO;

import javax.validation.constraints.NotBlank;

public class CadastraCategoria {
	
	@NotBlank
	String nome;

	public CadastraCategoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
