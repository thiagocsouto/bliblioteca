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

import br.com.bliblioteca.entity.Livro;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.LivroRepository;
import br.com.bliblioteca.service.LivroService;

@SpringBootTest
public class LivroServiceTest {
	
	@InjectMocks 
	private LivroService livroService;
	 
	@Mock
	private LivroRepository livroRepository;
	
	@Test
	void testeDeveRetornarAutor() throws Exception {
		 
	    Livro livro = new Livro("Flor", "Um livro sobre flores" ,"230.00","100", "ESTUDOS");
	    
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
		   Livro livro1 = new Livro("Flor", "Um livro sobre flores" ,"230.00","100", "ESTUDOS");
		   Livro livro2 = new Livro("Flor", "Um livro sobre flores" ,"230.00","100", "ESTUDOS");
		   Livro livro3 = new Livro("Flor", "Um livro sobre flores" ,"230.00","100", "ESTUDOS");
        doReturn(Arrays.asList(livro1, livro2, livro3)).when(livroRepository).findAll();
        
        List<Livro> livros = livroService.listarLivros();
        
        Assertions.assertEquals(3, livros.size());
        
	}

}
