package br.com.bliblioteca.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest { 
	
	@InjectMocks 
	private AutorService autorService;
	 
	@Mock
	private AutorRepository autorRepository;
	
	@Test
	void testeDeveSalvarAutor() throws Exception { 
	    Autor autor = new Autor(1, "Thiago");
	    
	    when(autorRepository.save(any())).thenReturn(autor);
	    
		Autor autorSave = autorService.salvarAutor(autor); 
	
		assertNotNull(autorSave);
	
	}
	
	@Test
	void testeIdNaoEncontradoAutor() throws Exception {
		   doReturn(Optional.empty()).when(autorRepository).findById(1);

	        Exception exception = assertThrows(NegocioException.class, ()-> autorService.listarAutorId(1)); 

	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeIdNaoPodeSerMenorIgualQueZeroAutor(){
		  Exception exception = assertThrows(NegocioException.class, ()-> autorService.listarAutorId(0)); 

	      Assertions.assertEquals("Id não pode ser menor ou igual zero.", exception.getMessage());
		
	}
	
	@Test
	void testeEncontrarTodosOsIdAutor() {
		Autor autor1 = new Autor(1, "Thiago Motta");
		Autor autor2 = new Autor(2, "Alan Wake");
		Autor autor3 = new Autor(3, "Santos");
        doReturn(Arrays.asList(autor1, autor2, autor3)).when(autorRepository).findAll();
        
        List<Autor> autores = autorService.listarAutores();
        
        Assertions.assertEquals(3, autores.size());
        
	}

}
