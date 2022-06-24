package br.com.bliblioteca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bliblioteca.entity.Livro;
import br.com.bliblioteca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {


	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public List<Livro> listarLivros(){
		return livroService.listarLivros();
	}
	
	@GetMapping("/{id}")
    public Optional<Livro> listarLivroId(@PathVariable("id") Integer id) throws Exception{
		return livroService.listarLivroId(id);
	}
	
	@PostMapping
	public Livro adicionarLivro(@RequestBody @Valid Livro livro) throws Exception {		
       return livroService.salvarLivro(livro);
	}
	
	@DeleteMapping("/{id}")
	public void deletarLivro(@PathVariable("id")Integer id) throws Exception {
		livroService.deletarLivroId(id);
	} 

}
