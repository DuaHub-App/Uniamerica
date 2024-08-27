package com.app.outlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.outlet.entity.Cliente;
import com.app.outlet.service.ClienteService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<?> createCliente( @RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = clienteService.save(cliente);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
//        Optional<Cliente> clienteExistente = clienteService.findById(id);
//
//        if (clienteExistente.isPresent()) {
//            Cliente clienteAtualizado = clienteExistente.get();
//            clienteAtualizado.setNome(cliente.getNome());
//            clienteAtualizado.setCpf(cliente.getCpf());
//            clienteAtualizado.setTelefone(cliente.getTelefone());
//            clienteAtualizado.setIdade(cliente.getIdade());
//            try {
//                clienteService.save(clienteAtualizado);
//                return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
//            } catch (IllegalArgumentException e) {
//                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            clienteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Cliente>> getClientesByNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteService.findByNome(nome);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/cpf")
    public ResponseEntity<List<Cliente>> getClientesByCpf(@RequestParam String cpf) {
        List<Cliente> clientes = clienteService.findByCpf(cpf);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/idade")
    public ResponseEntity<List<Cliente>> getClientesByIdadeMaiorOuIgual(@RequestParam Integer idade) {
        List<Cliente> clientes = clienteService.findByIdadeMaiorOuIgual(idade);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
