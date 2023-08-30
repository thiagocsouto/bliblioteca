package br.com.bliblioteca.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bliblioteca.entity.Livro;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.LivroRepository;

@SpringBootTest
public class LivroServiceTest {
	
	@InjectMocks 
	private LivroService livroService;
	 
	@Mock
	private LivroRepository livroRepository;
	
	@Test
	void testeDeveRetornarAutor() throws Exception {
		 
	    Livro livro = new Livro(1, "Dias de um futuro esquecido", 2014, "Uma história de romance", "sumario", "Bom", "430", "123456-1233", Date.valueOf("2013-02-06"));
	    
	    when(livroRepository.save(any())).thenReturn(livro);
	    
		Livro livrosave = livroService.salvarLivro(livro);
	
		assertNotNull(livrosave);
	
	}
	
	@Test
	void testeIdNaoEncontrado() throws Exception {
		
		   doReturn(Optional.empty()).when(livroRepository).findById(1);

	       Exception exception = assertThrows(NegocioException.class, ()-> livroService.listarLivroId(1));

	       Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeEncontrarTodosOsId() {
		Livro livro1 = new Livro(1, "Dias de um futuro esquecido", 2014, "Uma história de romance", "sumario", "Bom", "430", "123456-1233", Date.valueOf("2023-02-06"));
	    Livro livro2 = new Livro(2, "Guerra do mundo", 2000, "Sobre a guerra entre Uk x Jk", "final", null, "240", "042456-9831", Date.valueOf("2022-06-11"));
		Livro livro3 = new Livro(3, "StarCampo", 2023, "Exploração espacial", "teste", "", "1000", "009336-8573", Date.valueOf("2018-04-01"));
        
		doReturn(Arrays.asList(livro1, livro2, livro3)).when(livroRepository).findAll();
        
        List<Livro> livros = livroService.listarLivros();
        
        Assertions.assertEquals(3, livros.size());
        
	}

}
