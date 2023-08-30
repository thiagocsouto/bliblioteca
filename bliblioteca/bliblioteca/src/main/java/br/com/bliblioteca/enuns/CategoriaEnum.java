package br.com.bliblioteca.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor 
public enum CategoriaEnum {
	
	Terror("terror"),
	Drama("Drama"),
	Ação("Ação"),
	Ficção("Ficção");
	
	private String Categoria;	

}
