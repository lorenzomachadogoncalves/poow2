ALTER TABLE usuario DROP CONSTRAINT fk_permissao;
DROP TABLE permissao;
CREATE TABLE permissao (
                           id_permissao SERIAL PRIMARY KEY,
                           nome VARCHAR(50) NOT NULL
);
ALTER TABLE usuario
ADD CONSTRAINT fk_permissao
FOREIGN KEY (id_permissao) REFERENCES permissao(id_permissao);