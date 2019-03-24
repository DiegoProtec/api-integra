create schema if not exists integradb authorization integra;

alter schema integradb owner to integra;

create sequence sq_endereco_coseqendereco;

alter sequence sq_endereco_coseqendereco owner to integra;

create sequence sq_item_coseqitem;

alter sequence sq_item_coseqitem owner to integra;

create sequence sq_pacote_coseqpacote;

alter sequence sq_pacote_coseqpacote owner to integra;

create sequence sq_pessoa_coseqpessoa;

alter sequence sq_pessoa_coseqpessoa owner to integra;

create table tb_endereco
(
  co_seq_endereco bigint not null
    constraint tb_endereco_pkey
      primary key,
  ds_bairro       varchar(255),
  ds_cidade       varchar(255),
  ds_complemento  varchar(255),
  ds_estado       varchar(255),
  ds_numero       varchar(255),
  ds_rua          varchar(255)
);

alter table tb_endereco
  owner to integra;

create table tb_item
(
  co_seq_item     bigint not null
    constraint tb_item_pkey
      primary key,
  nu_altura       double precision,
  ds_descricao    varchar(255),
  nu_largura      double precision,
  nu_peso         double precision,
  nu_profundidade double precision,
  nu_valor        double precision
);

alter table tb_item
  owner to integra;

create table tb_pessoa
(
  co_seq_pessoa bigint not null
    constraint tb_pessoa_pkey
      primary key,
  ds_cpf        varchar(255),
  ds_nome       varchar(255),
  ds_telefone   varchar(255)
);

alter table tb_pessoa
  owner to integra;

create table rl_pessoa_endereco
(
  co_seq_pessoa   bigint not null
    constraint fk6wq3bca174ame84xx1le8qln3
      references tb_pessoa,
  co_seq_endereco bigint not null
    constraint fkhtqor1ijevkkljh05pp6icprd
      references tb_endereco,
  constraint rl_pessoa_endereco_pkey
    primary key (co_seq_pessoa, co_seq_endereco)
);

alter table rl_pessoa_endereco
  owner to integra;

create table tb_pacote
(
  co_seq_pacote    bigint not null
    constraint tb_pacote_pkey
      primary key,
  nu_valor         double precision,
  cod_destinatario bigint
    constraint fkk9vrfo3khbsi0ctv1vsqe86lh
      references tb_pessoa,
  cod_remetente    bigint
    constraint fkgrak6isip8hnyda1g97n3581x
      references tb_pessoa
);

alter table tb_pacote
  owner to integra;

create table rl_pacote_item
(
  co_seq_pacote bigint not null
    constraint fk7d5qmg1ph0w288retjcq0f0s0
      references tb_pacote,
  co_seq_item   bigint not null
    constraint fkjt81q8ipjrhfi8wdebmt2w19v
      references tb_item,
  constraint rl_pacote_item_pkey
    primary key (co_seq_pacote, co_seq_item)
);

alter table rl_pacote_item
  owner to integra;

create table tb_usuario
(
  ds_email             varchar(255),
  ds_senha             varchar(255),
  pessoa_co_seq_pessoa bigint not null
    constraint tb_usuario_pkey
      primary key
    constraint fkmfq4iljygban61tvkkl8ou86a
      references tb_pessoa
);

alter table tb_usuario
  owner to integra;

