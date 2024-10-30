package com.A.UsuarioService.repository;

import com.A.UsuarioService.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByEmailAndPassword(String email, String password);

}
