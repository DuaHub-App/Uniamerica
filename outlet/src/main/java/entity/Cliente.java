package entity;

import lombok.Data;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull; 

import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//aqui diz que o id é um valor gerado automaticamente
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")//valida o campo nome como não nulo
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")//faz a validação de tamanho do nome
    private String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")//valida o cpf como um dado que tenha 11 digitos e conta apenas os numeros como digitos validos
    private String cpf;

    @NotNull(message = "Idade não pode ser nula")
    private Integer idade;

    @NotNull(message = "Telefone não pode ser nulo")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
}
