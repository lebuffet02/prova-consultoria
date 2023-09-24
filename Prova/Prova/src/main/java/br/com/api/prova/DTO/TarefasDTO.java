package br.com.api.prova.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "titulo",
        "descricao",
        "prazo",
        "departamento",
        "pessoaAlocada",
        "isFinalizado"

})
public class TarefasDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("prazo")
    private String prazo;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("pessoaAlocada")
    private String pessoaAlocada;

    @JsonProperty("isFinalizado")
    private boolean isFinalizado;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("titulo")
    public String getTitulo() {
        return titulo;
    }

    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("prazo")
    public String getPrazo() {
        return prazo;
    }

    @JsonProperty("prazo")
    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    @JsonProperty("departamento")
    public String getDepartamento() {
        return departamento;
    }

    @JsonProperty("departamento")
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @JsonProperty("pessoaAlocada")
    public String getPessoaAlocada() {
        return pessoaAlocada;
    }

    @JsonProperty("pessoaAlocada")
    public void setPessoaAlocada(String pessoaAlocada) {
        this.pessoaAlocada = pessoaAlocada;
    }

    @JsonProperty("isFinalizado")
    public boolean isFinalizado() {
        return isFinalizado;
    }

    @JsonProperty("isFinalizado")
    public void setFinalizado(boolean finalizado) {
        isFinalizado = finalizado;
    }
}





