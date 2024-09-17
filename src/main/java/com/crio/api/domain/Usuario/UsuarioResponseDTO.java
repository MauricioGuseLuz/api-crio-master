package com.crio.api.domain.Usuario;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nomeCompleto,
        String email,
        String senha,
        int tipo
) {
}
