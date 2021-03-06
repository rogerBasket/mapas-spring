package com.roger.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.hibernate.dao.MapasDAO;
import com.roger.hibernate.dao.PerfilesDAO;
import com.roger.hibernate.dao.UsuariosDAO;
import com.roger.hibernate.dto.Mapas;
import com.roger.hibernate.dto.Perfiles;
import com.roger.hibernate.dto.Usuarios;
import com.roger.services.UsuariosServices;

@Service
public class UsuariosServicesImpl implements UsuariosServices {
	@Autowired
	private UsuariosDAO usuariosDAOImpl;
	
	@Autowired
	private PerfilesDAO perfilesDAOImpl;
	
	@Autowired
	private MapasDAO mapasDAOImpl;
	
	@Override
	public Object loginUsuario(Usuarios usuario) {
		Usuarios u = null;
		String resul = "login";
		
		try {
			List<Usuarios> l = usuariosDAOImpl.readData(usuario);
			if(l.size() == 1) {
				u = l.get(0);
				//System.out.println(u);
				if(u.getUser().equals(usuario.getUser()) && u.getPass().equals(usuario.getPass())) {
					if(u.getPerfil().getDescripcion().equals("administrador"))
						resul = "admin";
					else
						resul = "usuario";
				}
			}
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = "error";
		}
				
		return new Object[] {u,resul};
	}

	@Override
	public Object registroUsuario(Usuarios usuario) {
		String resul = "registro";
		
		try {
			List<Usuarios> l = usuariosDAOImpl.readData(usuario);
			if(l.size() == 0) {
				List<Perfiles> p = perfilesDAOImpl.readId(new Perfiles(2));
				usuario.setPerfil(p.get(0));
				usuariosDAOImpl.create(usuario);
				resul = "usuario";
			}
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = "error";
		}
		
		return new Object[] {usuario,resul};
	}

	@Override
	public Object mapasUsuario(Usuarios usuario) {
		String resul = "listar_mapas";
		List<Mapas> l = null;
		
		try {
			l = mapasDAOImpl.listarByUsuario(usuario);
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = "error";
		}
		
		return new Object[] {l,resul};
	}

	@Override
	public Object contribuciones(Usuarios usuario) {
		String resul = "contribuciones_mapas";
		List<Mapas> l = null;
		
		try {
			l = mapasDAOImpl.listarByNotUsuario(usuario);
		} catch(HibernateException he) {
			he.printStackTrace();
			resul = "error";
		}
		
		return new Object[] {l,resul};
	}
}
