package br.com.bliblioteca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.bliblioteca.controller.AutorController;
import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.AutorRepository;
import br.com.bliblioteca.service.AutorService;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest { 
	
	@InjectMocks 
	private AutorService autorService;
	 
	@Mock
	private AutorRepository autorRepository;
	
	@Test
	void testeDeveSalvarAutor() throws Exception { 
	    Autor autor = new Autor("Thiago", "thiagocsouto@gmail.com", "sem descrição");
	    
	    when(autorRepository.save(any())).thenReturn(autor);
	    
		Autor autorsave = autorService.salvarAutor(autor); 
	
		assertNotNull(autorsave);
	
	}
	
//	@Test
//	void testeEmailNaoPodeSerIgual() throws Exception {
//		Autor autor1 = new Autor("Thiago Motta", "thiagomotta8@gmail.com", "Sem descrição.");
//		Autor autor2 = new Autor("Alan Wake", "thiagomotta8@gmail.com", "Bom escritor.");
//		doReturn(autor1, autor2).when(autorRepository).save(any());
//		
//		Exception exception = assertThrows(NegocioException.class, ()-> autorService.salvarAutor(autor2)); 
//
//	     Assertions.assertEquals("Email já cadastrado no sistema.", exception.getMessage());
//	}
//	
	
	@Test
	void testeIdNaoEncontrado() throws Exception {
		   doReturn(Optional.empty()).when(autorRepository).findById(1);

	        Exception exception = assertThrows(NegocioException.class, ()-> autorService.listarAutorId(1)); 

	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeIdNaoPodeSerMenorIgualQueZero(){
		  Exception exception = assertThrows(NegocioException.class, ()-> autorService.listarAutorId(0)); 

	      Assertions.assertEquals("Id não pode ser menor ou igual zero.", exception.getMessage());
		
	}
	
	@Test
	void testeEncontrarTodosOsId() {
		Autor autor1 = new Autor("Thiago Motta", "thiagomotta8@gmail.com", "Sem descrição.");
		Autor autor2 = new Autor("Alan Wake", "lobiosouto@gmail.com", "Bom escritor.");
		Autor autor3 = new Autor("Santos", "souzanasguerras@outlook.com", "sem descrição.");
        doReturn(Arrays.asList(autor1, autor2, autor3)).when(autorRepository).findAll();
        
        List<Autor> autores = autorService.listarAutores();
        
        Assertions.assertEquals(3, autores.size());
        
	}

}
