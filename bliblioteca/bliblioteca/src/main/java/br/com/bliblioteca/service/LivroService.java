package br.com.bliblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bliblioteca.entity.Livro;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listarLivros() {
		return livroRepository.findAll();
	}
	
	public Optional<Livro> listarLivroId(Integer id) throws NegocioException {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
		    return livro; 
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
	
	public Livro salvarLivro(Livro livro) throws Exception{	
		return livroRepository.save(livro);
	}
	
	public void deletarLivroId(Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
			livroRepository.deleteById(id);
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
	
}
