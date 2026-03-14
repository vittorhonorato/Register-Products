package io.github.vittorhonorato.produtosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("valor_unidade")
    private double valorUnidade;

    @JsonProperty("quantidade")
    private int quantidade;
}
