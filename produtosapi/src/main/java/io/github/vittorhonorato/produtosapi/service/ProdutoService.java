package io.github.vittorhonorato.produtosapi.service;

import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.dto.ProductResponseDTO;
import io.github.vittorhonorato.produtosapi.exception.ProductConflit;
import io.github.vittorhonorato.produtosapi.exception.ProductNotFound;
import io.github.vittorhonorato.produtosapi.mapper.ProductMapper;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements ProductUseCase {

    private final ProdutoRepository produtoRepository;
    private final ProductMapper productMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProductMapper productMapper) {
        this.produtoRepository = produtoRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDTO> getAll(){
        List<ProdutoModel> products = produtoRepository.findAll();

        return  products.stream()
                .map(productMapper::toProductDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getById(Long id){
        ProdutoModel produtoModel = produtoRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Produto com o id: " + id + " não encontrado"));
        return productMapper.toProductDTO(produtoModel);
    }

    @Override
    public void createProduto(ProductDTO produto){

        if(produtoRepository.existsByNome(produto.getNome())) {
            throw new ProductConflit("Produto: " +  produto.getNome() + " já existe");
        }

        produtoRepository.save(productMapper.toProductModel(produto));
    }

    @Override
    public void deleteProduto(Long id){
        findProductById(id);

        produtoRepository.deleteById(id);
    }

    @Override
    public void updateProduto(ProductDTO produto, Long id) {
        findProductById(id);

        ProdutoModel produtoModel = productMapper.toUpdateProductModel(produto, id);

        produtoRepository.save(produtoModel);
    }

    private void findProductById(Long id) {
        produtoRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Produto com o id: " + id + " não encontrado"));
    }
}
