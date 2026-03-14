package io.github.vittorhonorato.produtosapi.controller;

import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProdutos(){
        return ResponseEntity.ok().body(produtoService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProdutosById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProduto(@RequestBody ProductDTO produto){
        produtoService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateProduto(@RequestBody ProductDTO produto, @PathVariable Long id){
        produtoService.updateProduto(produto, id);
       return ResponseEntity.noContent().build();
    }
}
