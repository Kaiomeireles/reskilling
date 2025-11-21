package com.fiap.futurotrabalho.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "area_atuacao", length = 100)
    private String areaAtuacao;

    @Column(name = "nivel_carreira", length = 50)
    private String nivelCarreira;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;
}
