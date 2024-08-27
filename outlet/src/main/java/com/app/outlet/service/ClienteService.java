package com.app.outlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.app.outlet.entity.Cliente;
import com.app.outlet.repository.ClienteRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Validated
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);
        if (violations.isEmpty()) {
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException(violations.iterator().next().getMessage());
        }
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findByIdadeMaiorOuIgual(Integer idade) {
        return clienteRepository.findByIdadeGreaterThanEqual(idade);
    }
}
