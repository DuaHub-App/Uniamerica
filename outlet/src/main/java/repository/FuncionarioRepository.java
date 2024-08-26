package repository;

import entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    Funcionario findByMatricula(String matricula);

    List<Funcionario> findByNomeContaining(String nome);

    List<Funcionario> findByIdadeBetween(Integer startAge, Integer endAge);
}
