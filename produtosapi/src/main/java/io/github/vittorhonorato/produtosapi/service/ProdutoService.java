package io.github.vittorhonorato.produtosapi.service;

import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.mapper.ProductMapper;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProductDTO> getAll(){
        List<ProdutoModel> products = produtoRepository.findAll();

        return  products.stream()
                .map(ProductMapper::toProductDTO)
                .toList();
    }

    public ProductDTO getById(Long id){
        ProdutoModel produtoModel = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProductMapper.toProductDTO(produtoModel);
    }

    public void createProduto(ProductDTO produto){

        produtoRepository.save(ProductMapper.toProductModel(produto));

    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public void updateProduto(ProductDTO produto, Long id) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(id);
        produtoModel.setNome(produto.getNome());
        produtoModel.setQuantidade(produto.getQuantidade());
        produtoModel.setValorUnidade(produto.getValorUnidade());

        produtoRepository.save(produtoModel);

    }
}
