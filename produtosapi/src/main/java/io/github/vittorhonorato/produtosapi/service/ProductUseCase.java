package io.github.vittorhonorato.produtosapi.service;

import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.dto.ProductResponseDTO;

import java.util.List;

public interface ProductUseCase {
    List<ProductResponseDTO> getAll();
    ProductResponseDTO getById(Long id);
    void createProduto(ProductDTO productDTO);
    void deleteProduto(Long id);
    void updateProduto(ProductDTO productDTO, Long id);
}
