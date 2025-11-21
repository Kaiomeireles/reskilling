package com.fiap.futurotrabalho.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trilhas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TrilhaAprendizagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 50)
    private String nivel;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "foco_principal", length = 100)
    private String focoPrincipal;
}
