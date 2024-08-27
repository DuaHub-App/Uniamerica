package com.app.outlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.outlet.entity.Venda;
import com.app.outlet.service.VendaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.findById(id);
        return venda.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venda createVenda(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Venda> updateVenda(@PathVariable Long id, @RequestBody Venda venda) {
//        Optional<Venda> optionalVenda = vendaService.findById(id);
//        if (optionalVenda.isPresent()) {
//            Venda vendaAtualizada = optionalVenda.get();
//            vendaAtualizada.setCliente(venda.getCliente());
//            vendaAtualizada.setFuncionario(venda.getFuncionario());
//            vendaAtualizada.setProdutos(venda.getProdutos());
//            vendaAtualizada.setValorTotal(venda.getValorTotal());
//            return ResponseEntity.ok(vendaService.save(vendaAtualizada));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
        vendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Venda> getVendasByClienteId(@PathVariable Long clienteId) {
        return vendaService.findByClienteId(clienteId);
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public List<Venda> getVendasByFuncionarioId(@PathVariable Long funcionarioId) {
        return vendaService.findByFuncionarioId(funcionarioId);
    }

    @GetMapping("/valor")
    public List<Venda> getVendasByValorTotalMaiorQue(@RequestParam Double valor) {
        return vendaService.findByValorTotalMaiorQue(valor);
    }

    @GetMapping("/cliente/nome/{nome}")
    public List<Venda> getVendasByClienteNome(@PathVariable String nome) {
        return vendaService.findByClienteNome(nome);
    }

    @GetMapping("/funcionario/nome/{nome}")
    public List<Venda> getVendasByFuncionarioNome(@PathVariable String nome) {
        return vendaService.findByFuncionarioNome(nome);
    }
}
