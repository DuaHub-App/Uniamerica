package entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@Size(min = 2, max = 100, message = "Nome deve ter de 2 a 100 caracteres")
	private String nome;
	
	@NotNull(message = "Idade não pode ser nula")
	@Size(min = 1, max = 2, message = "Idade tem que ter um numero valido")
	private Integer idade;
	
	@NotNull(message = "CPF não pode ser nulo")
	@Pattern(regexp = "\\{11}", message = "CPF deve conter 11 digitos")
	private String cpf;
	
	@NotNull
	@Column(unique = true)//faz com que a matricula seja uma chave unica no banco de dados
	private String matricula;

}
