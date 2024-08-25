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
	
	@NotNull
	private String nome;
	
	@NotNull
	private Double valor;
	
	//@NotNull
	//private int quantidadeEstoque;futuramente pode ser implementado
	
}
