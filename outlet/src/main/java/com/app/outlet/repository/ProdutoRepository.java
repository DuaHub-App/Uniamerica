package com.app.outlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.outlet.entity.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByValorLessThanEqual(Double valor);//procura uma lista de produtos que tenham o valor menor ou igual ao requisitado

    List<Produto> findByNomeStartingWith(String prefix);//procura uma lista de produtos que começam com a letra requisitada

    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Produto> findByNomeContainingIgnoreCase(@Param("nome") String nome);//procura uma lista de produtos a partir dp nome requisitado, ignorando as maiusculas e minusculas
}
