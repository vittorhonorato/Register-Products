package io.github.vittorhonorato.produtosapi.mapper;

import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;

public class ProductMapper {

    public static ProductDTO toProductDTO(ProdutoModel model)  {
        ProductDTO productDTO = ProductDTO.builder()
                .nome(model.getNome())
                .valorUnidade(model.getValorUnidade())
                .quantidade(model.getQuantidade())
                .build();

        return  productDTO;
    }

    public static ProdutoModel toProductModel(ProductDTO dto) {
        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setNome(dto.getNome());
        produtoModel.setQuantidade(dto.getQuantidade());
        produtoModel.setValorUnidade(dto.getValorUnidade());

        return produtoModel;

    }
}
