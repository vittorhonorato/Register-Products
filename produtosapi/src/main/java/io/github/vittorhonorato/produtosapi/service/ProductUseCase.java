package io.github.vittorhonorato.produtosapi.service;

import io.github.vittorhonorato.produtosapi.dto.ProductRequestDTO;
import io.github.vittorhonorato.produtosapi.dto.ProductResponseDTO;

import java.util.List;

public interface ProductUseCase {
    List<ProductResponseDTO> getAll();
    ProductResponseDTO getById(Long id);
    void createProduto(ProductRequestDTO productRequestDTO);
    void deleteProduto(Long id);
    void updateProduto(ProductRequestDTO productRequestDTO, Long id);
}
