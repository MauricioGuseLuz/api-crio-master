package com.crio.api.domain.Evento;

import java.time.LocalDateTime;

public record LocalIntervaloDTO(
        String local,
        LocalDateTime inicio,
        LocalDateTime fim

) {
}
