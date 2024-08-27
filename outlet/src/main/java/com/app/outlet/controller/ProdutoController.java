package com.app.outlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.outlet.entity.Produto;
import com.app.outlet.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
//        Optional<Produto> optionalProduto = produtoService.findById(id);
//        if (optionalProduto.isPresent()) {
//            Produto produtoAtualizado = optionalProduto.get();
//            produtoAtualizado.setNome(produto.getNome());
//            produtoAtualizado.setDescricao(produto.getDescricao());
//            produtoAtualizado.setValor(produto.getValor());
//            produtoAtualizado.setQuantidade(produto.getQuantidade());
//            return ResponseEntity.ok(produtoService.save(produtoAtualizado));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public List<Produto> getProdutosByNome(@PathVariable String nome) {
        return produtoService.findByNome(nome);
    }

    @GetMapping("/valor")
    public List<Produto> getProdutosByValorMenorOuIgual(@RequestParam Double valor) {
        return produtoService.findByValorMenorOuIgual(valor);
    }

    @GetMapping("/prefixo/{prefix}")
    public List<Produto> getProdutosByNomeComecandoCom(@PathVariable String prefix) {
        return produtoService.findByNomeComecandoCom(prefix);
    }
}
