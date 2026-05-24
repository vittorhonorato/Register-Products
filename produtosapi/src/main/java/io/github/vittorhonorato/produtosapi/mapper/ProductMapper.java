package io.github.vittorhonorato.produtosapi.mapper;

import io.github.vittorhonorato.produtosapi.dto.ProductRequestDTO;
import io.github.vittorhonorato.produtosapi.dto.ProductResponseDTO;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toProductDTO(ProdutoModel model)  {
        return ProductResponseDTO.builder()
                .id(model.getId())
                .nome(model.getNome())
                .valorUnidade(model.getValorUnidade())
                .quantidade(model.getQuantidade())
                .build();
    }

    public ProdutoModel toProductModel(ProductRequestDTO dto) {
        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setNome(dto.getNome());
        produtoModel.setQuantidade(dto.getQuantidade());
        produtoModel.setValorUnidade(dto.getValorUnidade());

        return produtoModel;

    }

    public ProdutoModel toUpdateProductModel(ProductRequestDTO dto, Long id) {
        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setId(id);
        produtoModel.setNome(dto.getNome());
        produtoModel.setQuantidade(dto.getQuantidade());
        produtoModel.setValorUnidade(dto.getValorUnidade());

        return produtoModel;

    }
}
