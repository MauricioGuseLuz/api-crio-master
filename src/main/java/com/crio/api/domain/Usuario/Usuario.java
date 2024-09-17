package com.crio.api.domain.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private int tipo;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
