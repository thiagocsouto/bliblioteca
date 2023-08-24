package br.com.bliblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.AutorRepository;


@Service
public class AutorService {	

	@Autowired
	private AutorRepository autorRepository;
	
	public Autor salvarAutor(Autor autor) throws Exception {
		
		return autorRepository.save(autor);
	}
	
	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}
	
	public Optional<Autor> listarAutorId(@PathVariable("id")Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não pode ser menor ou igual zero.");
		}
		
        Optional<Autor> autor = autorRepository.findById(id);
		 
		if (autor.isPresent()) {
		    return autor; 
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
		
	}
	
	public void deletarId(@PathVariable("id")Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
      
		Optional<Autor> autor = autorRepository.findById(id);
		
		if (autor.isPresent()) {
			autorRepository.deleteById(id);
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}

}
