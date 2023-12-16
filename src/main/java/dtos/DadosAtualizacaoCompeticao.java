package dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoCompeticao(
        @NotNull
        UUID id,
        String nome,
        String modalidade,
        String presenca
) {
}
