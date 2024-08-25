package repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	List<Venda> findByClienteId(Long clienteId);
    List<Venda> findByFuncionarioId(Long funcionarioId);
    @Query("SELECT v FROM Venda v WHERE v.valorTotal > :valor")
    List<Venda> findByValorTotalGreaterThan(@Param("valor") Double valor);

}
