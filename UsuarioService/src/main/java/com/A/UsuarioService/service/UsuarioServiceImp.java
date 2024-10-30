package com.A.UsuarioService.service;

import com.A.UsuarioService.entity.Usuario;
import com.A.UsuarioService.repository.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServiceImp(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario registrarUsuario(Usuario user) {
        return usuarioRepositorio.save(user);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario login(String email, String password) {
        return usuarioRepositorio.findByEmailAndPassword(email, password);
    }
}
