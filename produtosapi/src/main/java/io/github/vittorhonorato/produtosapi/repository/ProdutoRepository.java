package io.github.vittorhonorato.produtosapi.repository;

import io.github.vittorhonorato.produtosapi.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
