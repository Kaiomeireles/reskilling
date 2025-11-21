package com.fiap.futurotrabalho.controller;

import com.fiap.futurotrabalho.dto.trilha.*;
import com.fiap.futurotrabalho.service.TrilhaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
@RequiredArgsConstructor
public class TrilhaController {

    private final TrilhaService service;

    @PostMapping
    public ResponseEntity<TrilhaResponseDTO> criar(@Valid @RequestBody TrilhaCreateDTO dto) {
        TrilhaResponseDTO criada = service.criar(dto);
        return ResponseEntity
                .created(URI.create("/trilhas/" + criada.id()))
                .body(criada);
    }

    @GetMapping
    public ResponseEntity<List<TrilhaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody TrilhaUpdateDTO dto
    ) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
