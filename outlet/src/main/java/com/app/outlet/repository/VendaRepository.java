package com.app.outlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.outlet.entity.Venda;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    
    List<Venda> findByClienteId(Long clienteId);

    List<Venda> findByFuncionarioId(Long funcionarioId);

    @Query("SELECT v FROM Venda v WHERE v.valorTotal > :valor")
    List<Venda> findByValorTotalGreaterThan(@Param("valor") Double valor);

    @Query("SELECT v FROM Venda v JOIN v.cliente c WHERE c.nome = :nome")
    List<Venda> findByClienteNome(@Param("nome") String nome);

    List<Venda> findByValorTotalGreaterThanEqual(Double valorTotal);

    List<Venda> findByFuncionarioNome(String nome);
}
