package com.fiap.futurotrabalho.dto.usuario;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String areaAtuacao,
        String nivelCarreira,
        LocalDate dataCadastro
) {}
