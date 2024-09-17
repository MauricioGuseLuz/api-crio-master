package com.crio.api.domain.Evento;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "evento")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean eventoPrivado;
    private String local;
    private String linkEvento;
    private String comoChegar;
    private String linkForms;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name ="endereco_id")
    private Endereco endereco;
}
