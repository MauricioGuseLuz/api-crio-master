package com.crio.api.domain.Evento;

import java.time.LocalDateTime;

public record IntervaloDataDTO(
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
