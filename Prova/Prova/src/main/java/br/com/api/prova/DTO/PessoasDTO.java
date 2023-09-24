package br.com.api.prova.DTO;

import br.com.api.prova.db.entity.TarefasEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nome",
        "departamento",
        "tarefas"

})
public class PessoasDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("departamento")
    private String departamento;
    private List<TarefasEntity> tarefas = new ArrayList<>();

    public PessoasDTO() {}

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("nome")
    public String getNomeDTO() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNomeDTO(String nome) {
        this.nome = nome;
    }

    @JsonProperty("departamento")
    public String getDepartamentoDTO() {
        return departamento;
    }

    @JsonProperty("departamento")
    public void setDepartamentoDTO(String departamento) {
        this.departamento = departamento;
    }

    @JsonProperty("tarefas")
    public List<TarefasEntity> getTarefasDTO() {
        return tarefas;
    }

    @JsonProperty("tarefas")
    public void setTarefasDTO(List<TarefasEntity> tarefas) {
        this.tarefas = tarefas;
    }
}
