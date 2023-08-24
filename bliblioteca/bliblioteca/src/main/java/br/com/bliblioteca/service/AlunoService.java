package br.com.bliblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bliblioteca.entity.Aluno;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> listarAlunoId(Integer id) throws NegocioException {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        var aluno = alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
		    return aluno; 
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
	
	public Aluno salvarCliente(Aluno cliente) throws Exception{
		
		var emailExiste = alunoRepository.findByEmail(cliente.getEmail()); 
		 
		if (emailExiste!= null) {
			throw new NegocioException("Email já cadastrado no sistema.");
		}
		
		return alunoRepository.save(cliente);
	}
	
	public void deletarAlunoId(Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        var aluno = alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
			alunoRepository.deleteById(id);
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
}
