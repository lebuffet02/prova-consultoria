
CREATE TABLE tarefas
(
    id            SERIAL PRIMARY KEY,
    titulo        TEXT,
    descricao     TEXT,
    prazo         TIMESTAMP WITH TIME ZONE,
    departamento_id BIGINT,
    pessoaAlocada BIGINT,
    duracao       INTERVAL,
    finalizado    BOOLEAN
);