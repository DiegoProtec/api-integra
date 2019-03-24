create table integradb.tb_endereco
(
  cod_endereco   bigint not null
    constraint tb_endereco_pkey primary key,
  ds_bairro      varchar(255),
  ds_cidade      varchar(255),
  ds_complemento varchar(255),
  ds_estado      varchar(255),
  ds_numero      varchar(255),
  ds_rua         varchar(255)
);

alter table integradb.tb_endereco
  owner to integra;

create table integradb.tb_item
(
  cod_item        bigint not null
    constraint tb_item_pkey primary key,
  nu_altura       double precision,
  ds_descricao    varchar(255),
  nu_largura      double precision,
  nu_peso         double precision,
  nu_profundidade double precision,
  nu_valor        double precision
);

alter table integradb.tb_item
  owner to integra;

create table integradb.tb_pessoa
(
  cod_pessoa  bigint not null
    constraint tb_pessoa_pkey
      primary key,
  ds_cpf      varchar(255),
  ds_nome     varchar(255),
  ds_telefone varchar(255)
);

alter table integradb.tb_pessoa
  owner to integra;

create table integradb.rl_pessoa_endereco
(
  cod_pessoa   bigint not null
    constraint fk8msy6hyqbf4o8d0wlapdt6gk6
      references integradb.tb_pessoa,
  cod_endereco bigint not null
    constraint fk9s3wlof14tmf1040h1cr6g4gn
      references integradb.tb_endereco,
  constraint rl_pessoa_endereco_pkey
    primary key (cod_pessoa, cod_endereco)
);

alter table integradb.rl_pessoa_endereco
  owner to integra;

create table integradb.tb_pacote
(
  cod_pacote       bigint not null
    constraint tb_pacote_pkey
      primary key,
  nu_valor         double precision,
  cod_destinatario bigint
    constraint fkk9vrfo3khbsi0ctv1vsqe86lh
      references integradb.tb_pessoa,
  cod_remetente    bigint
    constraint fkgrak6isip8hnyda1g97n3581x
      references integradb.tb_pessoa
);

alter table integradb.tb_pacote
  owner to integra;

create table integradb.rl_pacote_item
(
  cod_pacote bigint not null
    constraint fkc0o4jw9hw21xvq3jf1vegjtr0
      references integradb.tb_pacote,
  cod_item   bigint not null
    constraint fkfsqt1tquqi7i8ve3u1s42ir5h
      references integradb.tb_item,
  constraint rl_pacote_item_pkey
    primary key (cod_pacote, cod_item)
);

alter table integradb.rl_pacote_item
  owner to integra;

create table integradb.tb_usuario
(
  ds_email          varchar(255),
  ds_senha          varchar(255),
  pessoa_cod_pessoa bigint not null
    constraint tb_usuario_pkey
      primary key
    constraint fk7nks17eh4j6id7sb1acbvbo88
      references integradb.tb_pessoa
);

alter table integradb.tb_usuario
  owner to integra;

