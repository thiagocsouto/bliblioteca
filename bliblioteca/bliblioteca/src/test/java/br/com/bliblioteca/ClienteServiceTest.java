package br.com.bliblioteca;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bliblioteca.entity.Cliente;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.ClienteRepository;
import br.com.bliblioteca.service.ClienteService;

@SpringBootTest
public class ClienteServiceTest {
	
	@InjectMocks 
	private ClienteService clienteService;
	 
	@Mock
	private ClienteRepository clienteRepository;
	
	@Test
	void testeDeveRetornarAutor() throws Exception {
		 
	    Cliente cliente = new Cliente("Thiago", "123.123.123-12" ,"thiagocsouto@gmail.com" );
	    
	    when(clienteRepository.save(any())).thenReturn(cliente);
	    
		Cliente autorsave = clienteService.salvarCliente(cliente);
	
		assertNotNull(autorsave);
	
	}
	
	@Test
	void testeIdNaoEncontrado() throws Exception {
		   doReturn(Optional.empty()).when(clienteRepository).findById(1);

	        Exception exception = assertThrows(NegocioException.class, ()-> clienteService.listarClienteId(1));

	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeEncontrarTodosOsId() {
		Cliente cliente1 = new Cliente("Thiago", "123.123.123-12" ,"thiagocsouto@gmail.com" );
		Cliente cliente2 = new Cliente("Thiago", "123.153.122-02" ,"thiagocsouto@gmail.com" );
		Cliente cliente3 = new Cliente("Thiago", "121.623.123-12" ,"thiagocsouto@gmail.com" );
        doReturn(Arrays.asList(cliente1, cliente2, cliente3)).when(clienteRepository).findAll();
        
        List<Cliente> clientes = clienteService.listarClientes();
        
        Assertions.assertEquals(3, clientes.size());
        
	}


}
