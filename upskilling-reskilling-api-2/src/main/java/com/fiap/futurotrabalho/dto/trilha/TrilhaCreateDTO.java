package com.fiap.futurotrabalho.dto.trilha;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TrilhaCreateDTO(
        @NotBlank(message = "nome é obrigatório")
        @Size(max = 150)
        String nome,

        String descricao,

        @NotBlank(message = "nivel é obrigatório")
        String nivel,

        @NotNull(message = "cargaHoraria é obrigatória")
        @Positive(message = "cargaHoraria deve ser positiva")
        Integer cargaHoraria,

        @Size(max = 100)
        String focoPrincipal
) {}
