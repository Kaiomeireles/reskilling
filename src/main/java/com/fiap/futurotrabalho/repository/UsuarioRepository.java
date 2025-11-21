package com.fiap.futurotrabalho.repository;

import com.fiap.futurotrabalho.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
