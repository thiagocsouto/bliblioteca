package br.com.bliblioteca;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.bliblioteca.controller.AutorController;
import br.com.bliblioteca.service.AutorService;

@SpringBootTest
@AutoConfigureMockMvc
public class AutorControllerTest {

	@MockBean
	private AutorController autorController;
	
	@Autowired
	private MockMvc mockMvc;
//	
//	  @Test
//	  void teste() throws Exception {
//	        doReturn(Optional.empty()).when(autorService).listarAutorId(1);
//
//	        // Execute the GET request
//	        mockMvc.perform(get("/autores/{id}", 1))
//	                // Validate the response code
//	                .andExpect(status().isNotFound());
//	    }
}
