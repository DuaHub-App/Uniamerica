package com.app.outlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.outlet.entity.Venda;
import com.app.outlet.repository.VendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }

    public List<Venda> findByClienteId(Long clienteId) {
        return vendaRepository.findByClienteId(clienteId);
    }

    public List<Venda> findByFuncionarioId(Long funcionarioId) {
        return vendaRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Venda> findByValorTotalMaiorQue(Double valor) {
        return vendaRepository.findByValorTotalGreaterThan(valor);
    }

    public List<Venda> findByClienteNome(String nome) {
        return vendaRepository.findByClienteNome(nome);
    }

    public List<Venda> findByValorTotalMaiorOuIgual(Double valorTotal) {
        return vendaRepository.findByValorTotalGreaterThanEqual(valorTotal);
    }

    public List<Venda> findByFuncionarioNome(String nome) {
        return vendaRepository.findByFuncionarioNome(nome);
    }
}