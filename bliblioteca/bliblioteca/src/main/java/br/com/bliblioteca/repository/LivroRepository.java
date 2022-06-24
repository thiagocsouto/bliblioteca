package br.com.bliblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bliblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
