package br.com.bliblioteca.service;

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

import br.com.bliblioteca.entity.Aluno;
import br.com.bliblioteca.exception.NegocioException;
import br.com.bliblioteca.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {
	
	@InjectMocks 
	private AlunoService alunoService;
	 
	@Mock
	private AlunoRepository AlunoRepository;
	
	@Test
	void testeDeveRetornarAutor() throws Exception {
		 
	    Aluno aluno = new Aluno (1, "Thiago", "123.123.123-12" , "A98321", "thiagocsouto@gmail.com" );
	    
	    when(AlunoRepository.save(any())).thenReturn(aluno);
	    
		Aluno alunoSave = alunoService.salvarCliente(aluno);
	
		assertNotNull(alunoSave);
	
	}
	
	@Test
	void testeIdNaoEncontrado() throws Exception {
		   doReturn(Optional.empty()).when(AlunoRepository).findById(1);

	        Exception exception = assertThrows(NegocioException.class, ()-> alunoService.listarAlunoId(1));

	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeEncontrarTodosOsId() {
		Aluno aluno1 = new Aluno(1, "Thiago", "123.123.123-12" , "A98321", "thiagocsouto@gmail.com");
		Aluno aluno2 = new Aluno(1, "Thiago", "123.123.123-12" , "A98321", "thiagocsouto@gmail.com");
		Aluno aluno3 = new Aluno(1, "Thiago", "123.123.123-12" , "A98321", "thiagocsouto@gmail.com");
        doReturn(Arrays.asList(aluno1, aluno2, aluno3)).when(AlunoRepository).findAll();
        
        List<Aluno> alunos = alunoService.listarAlunos();
        
        Assertions.assertEquals(3, alunos.size());
        
	}


}
