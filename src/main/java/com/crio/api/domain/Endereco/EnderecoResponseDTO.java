package com.crio.api.domain.Endereco;

import java.util.UUID;

public record EnderecoResponseDTO(
        UUID id,
        String cidade,
        String uf

) {
}
