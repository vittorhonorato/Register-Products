package io.github.vittorhonorato.produtosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.vittorhonorato.produtosapi.dto.validation.ValorEQuantidadeObrigatorios;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@ValorEQuantidadeObrigatorios
@Builder
public class ProductRequestDTO {

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
