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

import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.entity.Cliente;
import br.com.bliblioteca.service.AutorService;
import br.com.bliblioteca.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{id}")
    public Optional<Cliente> listarClienteId(@PathVariable("id") Integer id) throws Exception{
		return clienteService.listarClienteId(id);
	}
	
	@PostMapping
	public Cliente adicionarCliente(@RequestBody @Valid Cliente cliente) throws Exception {		
       return clienteService.salvarCliente(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable("id")Integer id) throws Exception {
		clienteService.deletarClienteId(id);
	} 

}
