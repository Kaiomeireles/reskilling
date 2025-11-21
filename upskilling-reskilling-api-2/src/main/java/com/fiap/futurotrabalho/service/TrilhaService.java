package com.fiap.futurotrabalho.service;

import com.fiap.futurotrabalho.dto.trilha.*;
import com.fiap.futurotrabalho.exception.TrilhaNaoEncontradaException;
import com.fiap.futurotrabalho.model.TrilhaAprendizagem;
import com.fiap.futurotrabalho.repository.TrilhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrilhaService {

    private final TrilhaRepository repository;

    public TrilhaResponseDTO criar(TrilhaCreateDTO dto) {
        TrilhaAprendizagem trilha = TrilhaAprendizagem.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .nivel(dto.nivel())
                .cargaHoraria(dto.cargaHoraria())
                .focoPrincipal(dto.focoPrincipal())
                .build();

        TrilhaAprendizagem salva = repository.save(trilha);
        return toResponse(salva);
    }

    public List<TrilhaResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public TrilhaResponseDTO buscarPorId(Long id) {
        TrilhaAprendizagem trilha = repository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));
        return toResponse(trilha);
    }

    public TrilhaResponseDTO atualizar(Long id, TrilhaUpdateDTO dto) {
        TrilhaAprendizagem trilha = repository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));

        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setFocoPrincipal(dto.focoPrincipal());

        TrilhaAprendizagem atualizada = repository.save(trilha);
        return toResponse(atualizada);
    }

    public void remover(Long id) {
        TrilhaAprendizagem trilha = repository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));
        repository.delete(trilha);
    }

    private TrilhaResponseDTO toResponse(TrilhaAprendizagem t) {
        return new TrilhaResponseDTO(
                t.getId(),
                t.getNome(),
                t.getDescricao(),
                t.getNivel(),
                t.getCargaHoraria(),
                t.getFocoPrincipal()
        );
    }
}
