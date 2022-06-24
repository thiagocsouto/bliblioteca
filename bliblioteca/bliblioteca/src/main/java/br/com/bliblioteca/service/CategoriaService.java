package br.com.bliblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bliblioteca.entity.Categoria;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria salvarCategoria(Categoria categoria) throws Exception {
		
		Categoria nomeExiste = categoriaRepository.findByNome(categoria.getNome());
		 
		if (nomeExiste!= null) {
			throw new NegocioException("Não pode ter duas categorias com o mesmo nome.");
		}	
		
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> listarCategoriaId(@PathVariable("id")Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual zero.");
		}
		
        Optional<Categoria> categoria = categoriaRepository.findById(id);
		 
		if (categoria.isPresent()) {
		    return categoria; 
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
		
	}
	
	public void deletarCategoriaId(@PathVariable("id")Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
      
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if (categoria.isPresent()) {
			categoriaRepository.deleteById(id);
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
	
	
}
