package br.com.bliblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bliblioteca.entity.Cliente;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> listarClienteId(Integer id) throws NegocioException {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
		    return cliente; 
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
	
	public Cliente salvarCliente(Cliente cliente) throws Exception{
		
		Cliente emailExiste = clienteRepository.findByEmail(cliente.getEmail()); 
		 
		if (emailExiste!= null) {
			throw new NegocioException("Email já cadastrado no sistema.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void deletarClienteId(Integer id) throws Exception {
		
		if (id <= 0) {
			throw new NegocioException("Id não encontrado.");
		}
		
        Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
		} else {
			throw new NegocioException("Id não encontrado.");
		}   
	}
}
