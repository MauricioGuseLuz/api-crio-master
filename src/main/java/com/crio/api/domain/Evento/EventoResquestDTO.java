package com.crio.api.domain.Evento;

import com.crio.api.domain.Endereco.Endereco;
import com.crio.api.domain.Usuario.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResquestDTO(
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        boolean eventoPrivado,
        String local,
        Usuario usuario,
        String linkEvento,
        String comoChegar,
        String linkForms,
        Endereco endereco


) {
}



