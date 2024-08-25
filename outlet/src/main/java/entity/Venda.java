package entity;

import lombok.Data;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name ="vendas")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String enderecoEntrega;
	
	@NotNull
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@ManyToMany
	@JoinTable(
			name = "venda_produto",
			joinColumns = @JoinColumn(name = "venda_id"), 
			inverseJoinColumns = @JoinColumn(name = "produto_id")
			)
	private List<Produto> produtos;
	
}
