package dtos;

import jakarta.validation.constraints.NotBlank;

public record CompeticaoDto(
        @NotBlank
        String nome,

        @NotBlank
        String modalidade,

        @NotBlank
        String presenca
) {
}
