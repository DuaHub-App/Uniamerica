package entity;

import lombok.Data;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome do produto não pode ser nulo")
	@Size(min = 1, max = 100, message = "Nome do produto deve ter entre 1 e 100 caracteres")
	private String nome;

	@NotNull(message = "Valor do produto não pode ser nulo")
	@DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser positivo")
	private Double valor;
	
	//@NotNull
	//private int quantidadeEstoque;futuramente pode ser implementado
	
}
