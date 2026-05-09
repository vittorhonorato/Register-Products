package io.github.vittorhonorato.produtosapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vittorhonorato.produtosapi.dto.ProductDTO;
import io.github.vittorhonorato.produtosapi.dto.ProductResponseDTO;
import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import io.github.vittorhonorato.produtosapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("http://localhost:4200")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProdutos(){
        return ResponseEntity.ok().body(produtoService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDTO> getProdutosById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduto(@RequestBody @Valid ProductDTO produto) throws JsonProcessingException {
        produtoService.createProduto(produto);

        String mensagemSemanticaCriacao = "Produto criado com sucesso: " + produto;

        ObjectMapper objectMapper = new ObjectMapper();
        var message = objectMapper.writeValueAsString(mensagemSemanticaCriacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(message);
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
