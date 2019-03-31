create sequence sq_cliente_coseqcliente;

alter sequence sq_cliente_coseqcliente owner to integra;

create sequence sq_email_coseqemail;

alter sequence sq_email_coseqemail owner to integra;

create sequence sq_telefone_coseqtelefone;

alter sequence sq_telefone_coseqtelefone owner to integra;

create sequence sq_usuario_cosequsuario;

alter sequence sq_usuario_cosequsuario owner to integra;

create table tb_cliente
(
    co_seq_cliente bigint       not null
        constraint tb_cliente_pkey
            primary key,
    ds_bairro      varchar(255) not null,
    ds_cep         varchar(8)   not null,
    ds_cidade      varchar(255) not null,
    ds_complemento varchar(255),
    ds_cpf         varchar(11)  not null,
    ds_logradouro  varchar(255) not null,
    ds_nome        varchar(100) not null,
    ds_uf          varchar(255) not null
);

alter table tb_cliente
    owner to integra;

create table tb_email
(
    co_seq_email bigint       not null
        constraint tb_email_pkey
            primary key,
    ds_email     varchar(255) not null
);

alter table tb_email
    owner to integra;

create table rl_cliente_email
(
    co_seq_cliente bigint not null
        constraint fk8a20v71emcm4cdusfr5ayd9r8
            references tb_cliente,
    co_seq_email   bigint not null
        constraint fkar7pr4cssyti5va6df593xlvm
            references tb_email,
    constraint rl_cliente_email_pkey
        primary key (co_seq_cliente, co_seq_email)
);

alter table rl_cliente_email
    owner to integra;

create table tb_telefone
(
    co_seq_telefone bigint       not null
        constraint tb_telefone_pkey
            primary key,
    ds_telefone     varchar(11)  not null,
    tipo_telefone   varchar(255) not null
);

alter table tb_telefone
    owner to integra;

create table rl_cliente_telefone
(
    co_seq_cliente  bigint not null
        constraint fkqi7yspwce293ds9wafof448u5
            references tb_cliente,
    co_seq_telefone bigint not null
        constraint fk2pynij2dfsirn1p4dubmfh6t7
            references tb_telefone,
    constraint rl_cliente_telefone_pkey
        primary key (co_seq_cliente, co_seq_telefone)
);

alter table rl_cliente_telefone
    owner to integra;

create table tb_usuario
(
    co_seq_usuario bigint       not null
        constraint tb_usuario_pkey
            primary key,
    ds_senha       varchar(300) not null,
    ds_usuario     varchar(16)  not null
        constraint uk_8iyqbuntytfrfqjkx5fv7ingk
            unique
);

alter table tb_usuario
    owner to integra;

create table tb_perfil
(
    usuario_co_seq_usuario bigint not null
        constraint fkdtpt4esqy1ehvcafuktknhvfy
            references tb_usuario,
    perfis                 integer
);

alter table tb_perfil
    owner to integra;

