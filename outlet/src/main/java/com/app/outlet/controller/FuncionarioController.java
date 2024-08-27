package com.app.outlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.outlet.entity.Funcionario;
import com.app.outlet.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
//        Optional<Funcionario> optionalFuncionario = funcionarioService.findById(id);
//        if (optionalFuncionario.isPresent()) {
//            Funcionario funcionarioAtualizado = optionalFuncionario.get();
//            funcionarioAtualizado.setNome(funcionario.getNome());
//            funcionarioAtualizado.setMatricula(funcionario.getMatricula());
//            funcionarioAtualizado.setIdade(funcionario.getIdade());
//            funcionarioAtualizado.setCargo(funcionario.getCargo());
//            return ResponseEntity.ok(funcionarioService.save(funcionarioAtualizado));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public List<Funcionario> getFuncionariosByNome(@PathVariable String nome) {
        return funcionarioService.findByNome(nome);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Funcionario> getFuncionarioByMatricula(@PathVariable String matricula) {
        Funcionario funcionario = funcionarioService.findByMatricula(matricula);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/idade")
    public List<Funcionario> getFuncionariosByIdadeEntre(@RequestParam Integer startAge, @RequestParam Integer endAge) {
        return funcionarioService.findByIdadeEntre(startAge, endAge);
    }
}
