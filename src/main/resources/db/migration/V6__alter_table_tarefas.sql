ALTER TABLE TAREFAS ADD CONSTRAINT fk_pessoas FOREIGN KEY (pessoaAlocada) REFERENCES pessoas(id);

ALTER TABLE TAREFAS ADD CONSTRAINT fk_departamento FOREIGN KEY (departamento_id) REFERENCES departamentos(id);