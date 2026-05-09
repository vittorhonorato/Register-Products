package io.github.vittorhonorato.produtosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    @JsonProperty("nome")
    @NotBlank(message = "Não poder ser null ou vazio")
    private String nome;

    @JsonProperty("valor_unidade")
    @NotNull(message = "Não poder ser null ou vazio")
    private Double valorUnidade;

    @JsonProperty("quantidade")
    @NotNull(message = "Não poder ser null ou vazio")
    private Integer quantidade;
}
