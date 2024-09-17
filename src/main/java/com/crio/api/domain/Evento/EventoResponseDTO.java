package com.crio.api.domain.Evento;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        boolean eventoPrivado,
        String local,
        String linkEvento,
        String comoChegar,
        String linkForms
) {
}
