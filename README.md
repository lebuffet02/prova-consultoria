# prova-consultoria

## Parte 1:


### Subir o Docker-compose:

```sh
docker-compose up -d
```

### Derrubar o Docker-compose:

```sh
docker-compose down
```

### Spring Security:
```sh
Adicionar um usuário na tabela users para evitar o 403 (Unauthorized) 
```

![login](login.png)


### Abrir o Swagger (Comando 1):
```sh
http://localhost:8085/swagger-ui/index.html#/
```

### Abrir o Swagger Json (Comando 2):
```sh
http://localhost:8085/v3/api-docs
```

![swagger](swagger.png)

## Os Selects utilizados no projeto encontram-se dentro das Migrations: 
**src/main/java/resources/db/migration**



## Desafio 2
| X   | Y  |   Z | Resposta |
|:----|:--:|----:|---------:|
| 3   | 2  |  11 |        B |
| 150 | 3  | 455 |        C |
| 7   | -1 |  -2 |        A |
| -2  | 5  |  -5 |        A |
| 50  | 3  | 155 |        C |



Os demais desafios encontram-se presentes dentro do código, mais especificamente no path: **com.example.demo**


### Select Objetivo: 
- Montar select que retorne nome do departamento, quantidade de tarefas finalizadas e quantidade de tarefas não finalizadas;


    @Query("SELECT d.nome AS nome_departamento,\n" +
            "COUNT(CASE WHEN t.finalizado = true THEN 1 ELSE NULL END) AS tarefas_finalizadas,\n" +
            "COUNT(CASE WHEN t.finalizado = false THEN 1 ELSE NULL END) AS tarefas_nao_finalizadas\n" +
            "FROM\n" +
            "departamento d\n" +
            "LEFT JOIN\n" +
            "TarefaEntity t ON d.id = t.departamento_id\n" +
            "GROUP BY\n" +
            "d.nome")



### Select Objetivo:
- Select que retorne título da tarefa, prazo, se tiver pessoa alocada na tarefa exibir como “Encaminhado para + nome do pessoa” caso contrário “Pendente” e total de horas que essa pessoa já gastou. Ordenar por prazo decrescente;


    @Query("SELECT\n" +
            "    t.titulo AS titulo_tarefa,\n" +
            "    t.prazo AS prazo,\n" +
            "    CASE\n" +
            "        WHEN t.pessoaAlocada IS NOT NULL THEN CONCAT('Encaminhado para ', p.nome)\n" +
            "        ELSE 'Pendente'\n" +
            "    END AS status,\n" +
            "    SUM(TIME_TO_SEC(COALESCE(t.duracao, '00:00:00'))) / 3600 AS total_horas_gastas\n" +
            "FROM\n" +
            "    TarefaEntity t \n" +
            "LEFT JOIN\n" +
            "    PessoaEntity p ON p.id = t.pessoaAlocada.id\n" +
            "ORDER BY\n" +
            "    t.prazo DESC\n")
