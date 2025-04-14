package io.github.vittorhonorato.produtosapi.controller;

import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoModel> getAllProdutos(){
        return produtoService.getAll();
    }

    @GetMapping("{id}")
    public ProdutoModel getProdutosById(@PathVariable Long id){
        return produtoService.getById(id);
    }

    @PostMapping("/create")
    public ProdutoModel createProduto(@RequestBody ProdutoModel produto){
        return produtoService.createProduto(produto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
    }

    @PutMapping("/update/{id}")
    public ProdutoModel updateProduto(@RequestBody ProdutoModel produto, @PathVariable Long id){
        produto.setId(id);
       return produtoService.createProduto(produto);
    }
}
