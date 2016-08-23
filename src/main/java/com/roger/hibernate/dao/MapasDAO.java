package com.roger.hibernate.dao;

import java.util.List;

import com.roger.hibernate.dto.Mapas;
import com.roger.hibernate.dto.Usuarios;

public interface MapasDAO {
	public void create(Mapas mapa);
	public Mapas read(Mapas mapa);
	public void update(Mapas mapa);
	public void delete(Mapas mapa);
	public List<Mapas> listar();
	public List<Mapas> listarByUsuario(Usuarios usuario);
	public List<Mapas> listarByNotUsuario(Usuarios usuario);
}
