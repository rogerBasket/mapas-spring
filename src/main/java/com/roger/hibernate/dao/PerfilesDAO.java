package com.roger.hibernate.dao;

import java.util.List;

import com.roger.hibernate.dto.Perfiles;

public interface PerfilesDAO {
	public void create(Perfiles perfil);
	public Perfiles read(Perfiles perfil);
	public List<Perfiles> readId(Perfiles perfil);
	public void update(Perfiles perfil);
	public void delete(Perfiles perfil);
	public List<Perfiles> listar();
}
