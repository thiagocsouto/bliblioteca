package br.com.bliblioteca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public List<Autor> listarAutores(){
		return autorService.listarAutores();
	}
	
	@GetMapping("/{id}")
    public Optional<Autor> listarAutorId(@PathVariable("id") Integer id) throws Exception{
		return autorService.listarAutorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor adicionarAutor(@RequestBody @Valid Autor autor) throws Exception {		
       return autorService.salvarAutor(autor);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAutor(@PathVariable("id")Integer id) throws Exception {
		autorService.deletarId(id);
	}
	
}
