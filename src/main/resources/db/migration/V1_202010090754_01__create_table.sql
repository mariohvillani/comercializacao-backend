create table componente (
	id serial primary key,
	codigo varchar(30) UNIQUE NOT null,
	descricao varchar(50) not null,
	unidade_medida smallint not null,
	moeda smallint not null,
	codigo_externo varchar(30),
	tipo smallint not null,
	tabela varchar(10) not null,
	aplicacao smallint not null,
	ativo smallint not null,
	hedge smallint not null
);
create index componente_idx on componente(codigo, unidade_medida, moeda, codigo_externo,
tipo, tabela, aplicacao, ativo, hedge);

create table componente_item (
	id serial primary key,
	codigo varchar(30) not null,
	descricao varchar(50) not null,
	componente_id int not null,
	CONSTRAINT fk_item_componente
      FOREIGN KEY(componente_id)
	  REFERENCES componente(id)
);
create unique index item_idx on componente_item(codigo, componente_id);

create table componente_componentes (
	id serial primary key,
	codigo varchar(30) not null,
	descricao varchar(50) not null,
	componente_id int not null,
	CONSTRAINT fk_componentes_componente
      FOREIGN KEY(componente_id)
	  REFERENCES componente(id)
);
create unique index componentes_idx on componente_componentes(codigo, componente_id);

create table componente_tipo_frete (
	id serial primary key,
	codigo varchar(30) not null,
	descricao varchar(50) not null,
	componente_id int not null,
	CONSTRAINT fk_tipo_frete_componente
      FOREIGN KEY(componente_id)
	  REFERENCES componente(id)
);
create unique index tipo_frete_idx on componente_tipo_frete(codigo, componente_id);

create table componente_finalidade (
	id serial primary key,
	codigo varchar(30) not null,
	descricao varchar(50) not null,
	componente_id int not null,
	CONSTRAINT fk_finalidade_componente
      FOREIGN KEY(componente_id)
	  REFERENCES componente(id)
);
create unique index finalidade_idx on componente_finalidade(codigo, componente_id);
