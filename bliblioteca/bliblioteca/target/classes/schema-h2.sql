create table autor(id integer auto_increment, nome varchar(60), email varchar(40), descrição varchar(400)); 

create table cliente(id integer auto_increment, nome varchar(60), cpf varchar(15) ,email varchar(40)); 

create table livro(id integer auto_increment, título varchar(50), resumo varchar(100), sumário varchar(40), preço varchar(10), 
página varchar(5), isbn varchar(40), data_publicação LocalDateTime); 

create table categoria(id integer auto_increment, nome varchar(60));

alter table livro add constraint fk_autor foreign key(autor_id)
references autor(autor_id); 

alter table livro add constraint fk_categoria foreign key(categoria_id)
references categoria(categoria_id);