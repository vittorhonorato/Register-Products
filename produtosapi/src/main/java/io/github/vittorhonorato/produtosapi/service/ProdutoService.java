package io.github.vittorhonorato.produtosapi.service;

import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> getAll(){
        return produtoRepository.findAll();
    }

    public ProdutoModel getById(Long id){
        return produtoRepository.findById(id).get();
    }

    public ProdutoModel createProduto(ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
