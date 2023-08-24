CREATE TABLE autor (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(60));

CREATE TABLE aluno (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(60), cpf VARCHAR(15), matricula VARCHAR(10), email VARCHAR(40));

CREATE TABLE livro (id INT AUTO_INCREMENT PRIMARY KEY, titulo VARCHAR(50), ano INT, resumo VARCHAR(100), sumario VARCHAR(40), observacao VARCHAR(100), pagina VARCHAR(5), isbn VARCHAR(40), data_publicacao DATE);

CREATE TABLE categoria (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(60));

--alter table livro add constraint fk_autor foreign key(autor_id) references autor(autor_id); 

--alter table livro add constraint fk_categoria foreign key(categoria_id) references categoria(categoria_id);