package br.com.bliblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bliblioteca.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	Aluno findByEmail(String email);

}
