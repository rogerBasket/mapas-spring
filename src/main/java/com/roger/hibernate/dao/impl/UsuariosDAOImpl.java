package com.roger.hibernate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roger.hibernate.dao.UsuariosDAO;
import com.roger.hibernate.dto.Usuarios;

@Repository
public class UsuariosDAOImpl implements UsuariosDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Usuarios usuario) throws HibernateException {
		System.out.println(usuario);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public Usuarios read(Usuarios usuario) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		return (Usuarios)session.get(Usuarios.class,usuario.getIdUsuario());
	}
	
	@SuppressWarnings({"unchecked","unused"})
	public List<Usuarios> readData(Usuarios usuario) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		
		Transaction t = session.beginTransaction();
		
		Query q = session.createQuery("from Usuarios u where u.user = :user");
		
		return q.setString("user",usuario.getUser()).list();
	}
	
	public void update(Usuarios usuario) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public void delete(Usuarios usuario) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(usuario);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> listar() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Usuarios");
		
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> listarByPerfil(int perfil) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Usuarios u where u.perfil = :perfil");
		
		return q.setInteger("perfil",perfil).list();
	}
}
