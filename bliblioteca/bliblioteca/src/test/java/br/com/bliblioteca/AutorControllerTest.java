package br.com.bliblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bliblioteca.controller.AutorController;
import br.com.bliblioteca.entity.Autor;
import br.com.bliblioteca.repository.AutorRepository;
import br.com.bliblioteca.service.AutorService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ExtendWith(MockitoExtension.class)
public class AutorControllerTest {
	
	private final String urlHost = "http://localhost:8080";

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	public void limparDados() {
		autorRepository.deleteAll();
	}
	
	
//	  @Test
//	  void teste() throws JsonProcessingException, Exception{
//		  
//		  Autor autor = new Autor("Thiago", "thiagocsouto@gmail.com", "sem descrição");
//		  
//	      mockMvc.perform(MockMvcRequestBuilders
//	            .post(urlHost + "autores")
//	            .contentType(MediaType.APPLICATION_JSON)
//	            .content(objectMapper.writeValueAsString(autor)))
//	            .andExpect(MockMvcResultMatchers.status().isOk());
//	      
//	      assertTrue(autor.isPresent());
//	      
//	    }
}
