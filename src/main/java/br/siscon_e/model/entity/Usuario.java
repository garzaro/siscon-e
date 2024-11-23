package br.siscon_e.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuario", schema = "siscoescola")
public class Usuario {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    
    @NotBlank(message = "O nome completo é obrigatório.")
    @Size(min = 5, message = "Nome deve ter no minino 5 caracteres.")
    @Column(name = "nome_completo", nullable = false, length = 150)
    private String nomeCompleto;
    
    @NotBlank(message = "O CPF é obrigatório.")
    @CPF(message = "O CPF deve seguir o padrão 000.000.000-00 para ser válido.")
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf; 
    
    @NotBlank(message = "O nome de usuário é obrigatório.")
    @Size(min = 5, message = "Nome de usuário deve ter no minino 5 caracteres.")
    @Column(name = "nome_usuario", nullable = false, length = 50)
    private String nomeUsuario;
    
    @NotBlank(message = "O nome email é obrigatório.")
    @Email(message = "Email deve ser válido.")
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @NotBlank(message = "Digite a senha.")
    @Column(name = "senha", nullable = false, length = 150)
    private String senha;
    
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
        
}
