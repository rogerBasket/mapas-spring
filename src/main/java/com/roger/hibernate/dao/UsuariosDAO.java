package com.roger.hibernate.dao;

import java.util.List;

import com.roger.hibernate.dto.Usuarios;

public interface UsuariosDAO {
	public void create(Usuarios usuario);
	public Usuarios read(Usuarios usuario);
	public List<Usuarios> readData(Usuarios usuario);
	public void update(Usuarios usuario);
	public void delete(Usuarios usuario);
	public List<Usuarios> listar();
	public List<Usuarios> listarByPerfil(int perfil);
}
