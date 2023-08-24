package br.com.bliblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bliblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

//	Autor findByEmail(String email);

//	Optional<Autor> findByEmail(String email);
//	
//	boolean existsByEmail(String email);


}
