package io.github.vittorhonorato.produtosapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double valorUnidade;

    private Integer quantidade;

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valorUnidade=" + valorUnidade +
                ", quantidade=" + quantidade +
                '}';
    }
}
