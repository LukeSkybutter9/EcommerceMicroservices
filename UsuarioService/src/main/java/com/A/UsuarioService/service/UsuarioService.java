package com.A.UsuarioService.service;

import com.A.UsuarioService.entity.Usuario;

public interface UsuarioService {

    public Usuario registrarUsuario(Usuario user);

    public Usuario buscarPorId(Long id);

    public Usuario login(String email, String password);

}
