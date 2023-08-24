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

import br.com.bliblioteca.entity.Aluno;
import br.com.bliblioteca.service.AlunoService;

@RestController
@RequestMapping("/clientes")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listarAlunos(){
		return alunoService.listarAlunos();
	}
	
	@GetMapping("/{id}")
    public Optional<Aluno> listarALunoId(@PathVariable("id") Integer id) throws Exception{
		return alunoService.listarAlunoId(id);
	}
	
	@PostMapping
	public Aluno adicionarAluno(@RequestBody @Valid Aluno aluno) throws Exception {		
       return alunoService.salvarCliente(aluno);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable("id")Integer id) throws Exception {
		alunoService.deletarAlunoId(id);
	} 

}
