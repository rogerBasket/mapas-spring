package com.roger.services;


import org.springframework.stereotype.Service;

import com.roger.hibernate.dto.Usuarios;

@Service
public interface UsuariosServices {
	public Object loginUsuario(Usuarios usuario);
	public Object registroUsuario(Usuarios usuario);
	public Object mapasUsuario(Usuarios usuario);
	public Object contribuciones(Usuarios usuario);
}
