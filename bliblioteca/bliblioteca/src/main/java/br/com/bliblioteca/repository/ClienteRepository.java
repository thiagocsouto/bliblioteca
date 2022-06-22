package br.com.bliblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bliblioteca.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByEmail(String email);

}
