BEGIN;

create table public.produtos(
	codigo serial primary key,
	nome varchar(30),
	observacao varchar(100)
);

create table public.doador(
  	codigo serial primary key,
	nome varchar(60),
	telefone varchar(20),
	dataDoacao date
);

create table public.doacao(
	codigo serial primary key,
	doador_id int not null,
	FOREIGN KEY (doador_id) REFERENCES doador(codigo)
);

create table public.item(
	codigo serial primary key,
	quantidade int,
	produto_id int not null, 
	FOREIGN KEY (produto_id) REFERENCES produtos(codigo),
	doacao_id int not null,
	FOREIGN KEY (doacao_id) REFERENCES doacao(codigo)
);

END;