package com.app.outlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.outlet.entity.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    Funcionario findByMatricula(String matricula);

    List<Funcionario> findByNomeContaining(String nome);//procura por um determinado nome requisitado

    List<Funcionario> findByIdadeBetween(Integer startAge, Integer endAge);//exibe uma lista de funcionarios entre as idades que foram requisitadas
}
