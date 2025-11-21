package com.fiap.futurotrabalho.service;

import com.fiap.futurotrabalho.dto.usuario.*;
import com.fiap.futurotrabalho.exception.UsuarioNaoEncontradoException;
import com.fiap.futurotrabalho.model.Usuario;
import com.fiap.futurotrabalho.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioResponseDTO criar(UsuarioCreateDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .areaAtuacao(dto.areaAtuacao())
                .nivelCarreira(dto.nivelCarreira())
                .dataCadastro(LocalDate.now())
                .build();

        Usuario salvo = repository.save(usuario);
        return toResponse(salvo);
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        return toResponse(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioUpdateDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setAreaAtuacao(dto.areaAtuacao());
        usuario.setNivelCarreira(dto.nivelCarreira());

        Usuario atualizado = repository.save(usuario);
        return toResponse(atualizado);
    }

    public void remover(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        repository.delete(usuario);
    }

    private UsuarioResponseDTO toResponse(Usuario u) {
        return new UsuarioResponseDTO(
                u.getId(),
                u.getNome(),
                u.getEmail(),
                u.getAreaAtuacao(),
                u.getNivelCarreira(),
                u.getDataCadastro()
        );
    }
}
