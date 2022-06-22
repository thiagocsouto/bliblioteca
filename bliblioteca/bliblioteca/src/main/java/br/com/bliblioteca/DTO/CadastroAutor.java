//package br.com.bliblioteca.DTO;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//import br.com.bliblioteca.entity.Autor;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//public class CadastroAutor {
//	
//	@NotBlank(message = "nome em formato inválido.")
//	private String nome;
//	
//	@Email
//	@NotBlank
//	private String email;
//	
//	@NotBlank
//	@Size(max = 400)
//	private String descrição;
//	
//	public CadastroAutor(@NotBlank(message = "nome em formato inválido.") String nome, @Email @NotBlank String email,
//			@NotBlank @Size(max = 400) String descrição) {
//		super();
//		this.nome = nome;
//		this.email = email;
//		this.descrição = descrição;
//	}
//
//
//	public Autor toModel() {
//		return new Autor(this.nome, this.email, this.descrição);
//
//		
//	}
//}
