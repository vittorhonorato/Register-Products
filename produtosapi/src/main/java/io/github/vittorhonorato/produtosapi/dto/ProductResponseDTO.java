package io.github.vittorhonorato.produtosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDTO {
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("valor_unidade")
    private double valorUnidade;

    @JsonProperty("quantidade")
    private int quantidade;
}
