package com.fiap.futurotrabalho.dto.trilha;

public record TrilhaResponseDTO(
        Long id,
        String nome,
        String descricao,
        String nivel,
        Integer cargaHoraria,
        String focoPrincipal
) {}
