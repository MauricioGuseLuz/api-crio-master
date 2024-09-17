package com.crio.api.domain.Usuario;

public record UsuarioRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        int tipo

) {
}
