-- Tabela disco
CREATE TABLE disco (
                       id_disco SERIAL PRIMARY KEY,
                       uuid UUID DEFAULT gen_random_uuid(),
                       nome VARCHAR(80) NOT NULL,
                       ano_lancamento INTEGER,
                       capa VARCHAR(300)
);

-- Tabela permissao
CREATE TABLE permissao (
                           id_permissao INTEGER PRIMARY KEY,
                           uuid UUID DEFAULT gen_random_uuid(),
                           nome VARCHAR(50) NOT NULL
);

-- Tabela usuario
CREATE TABLE usuario (
                         id_usuario SERIAL PRIMARY KEY,
                         uuid UUID DEFAULT gen_random_uuid(),
                         nome VARCHAR(50) NOT NULL,
                         cpf VARCHAR(11) UNIQUE NOT NULL,
                         senha VARCHAR(50) NOT NULL,
                         email VARCHAR(50) UNIQUE NOT NULL,
                         id_permissao INTEGER,
                         CONSTRAINT fk_permissao FOREIGN KEY (id_permissao) REFERENCES permissao(id_permissao)
);

-- Tabela membro
CREATE TABLE membro (
                        id_membro INTEGER PRIMARY KEY,
                        uuid UUID DEFAULT gen_random_uuid(),
                        CONSTRAINT fk_usuario_membro FOREIGN KEY (id_membro) REFERENCES usuario(id_usuario)
);

-- Tabela funcionario
CREATE TABLE funcionario (
                             id_funcionario INTEGER PRIMARY KEY,
                             uuid UUID DEFAULT gen_random_uuid(),
                             CONSTRAINT fk_usuario_funcionario FOREIGN KEY (id_funcionario) REFERENCES usuario(id_usuario)
);

-- Tabela avaliacao
CREATE TABLE avaliacao (
                           id_membro INTEGER,
                           id_disco INTEGER,
                           uuid UUID DEFAULT gen_random_uuid(),
                           nota NUMERIC(4, 2),
                           PRIMARY KEY (id_membro, id_disco),
                           CONSTRAINT fk_avaliacao_membro FOREIGN KEY (id_membro) REFERENCES membro(id_membro),
                           CONSTRAINT fk_avaliacao_disco FOREIGN KEY (id_disco) REFERENCES disco(id_disco)
);
