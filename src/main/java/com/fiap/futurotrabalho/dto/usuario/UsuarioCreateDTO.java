package com.fiap.futurotrabalho.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(
        @NotBlank(message = "nome é obrigatório")
        @Size(max = 100)
        String nome,

        @NotBlank(message = "email é obrigatório")
        @Email(message = "email inválido")
        @Size(max = 150)
        String email,

        @Size(max = 100)
        String areaAtuacao,

        @Size(max = 50)
        String nivelCarreira
) {}
