-- senhas para ambos 123456
INSERT INTO tb_usuario (co_seq_usuario, ds_senha, ds_usuario) VALUES (1, '$2a$10$m0AC8yVpbM8yqR.dAxmQB.6Rpyzb66FG2EoS21upCYYSoNPxS7S.a', 'admin');
INSERT INTO tb_usuario (co_seq_usuario, ds_senha, ds_usuario) VALUES (2, '$2a$10$m0AC8yVpbM8yqR.dAxmQB.6Rpyzb66FG2EoS21upCYYSoNPxS7S.a', 'comum');
INSERT INTO tb_perfil (usuario_co_seq_usuario, perfis) VALUES (1, 1);
INSERT INTO tb_perfil (usuario_co_seq_usuario, perfis) VALUES (2, 2);