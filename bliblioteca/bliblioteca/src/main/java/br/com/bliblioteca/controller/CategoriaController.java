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

import br.com.bliblioteca.entity.Categoria;
import br.com.bliblioteca.service.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listarCategorias(){
		return categoriaService.listarCategorias();
	}
	
	@GetMapping("/{id}")
    public Optional<Categoria> listarCategoriaId(@PathVariable("id") Integer id) throws Exception{
		return categoriaService.listarCategoriaId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria adicionarCategoria(@RequestBody @Valid Categoria categoria) throws Exception {		
       return categoriaService.salvarCategoria(categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCategoria(@PathVariable("id")Integer id) throws Exception {
		categoriaService.deletarCategoriaId(id);
	}
	

}
