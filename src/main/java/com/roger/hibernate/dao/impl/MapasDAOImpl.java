package com.roger.hibernate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roger.hibernate.dao.MapasDAO;
import com.roger.hibernate.dto.Mapas;
import com.roger.hibernate.dto.Usuarios;

@Repository
public class MapasDAOImpl implements MapasDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Mapas mapa) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public Mapas read(Mapas mapa) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		return (Mapas)session.get(Mapas.class,mapa.getIdMapa());
	}
	
	public void update(Mapas mapa) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public void delete(Mapas mapa) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(mapa);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Mapas> listar() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Mapas");
		
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mapas> listarByUsuario(Usuarios usuario) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Mapas m where m.usuario = :usuario");
		
		return q.setParameter("usuario",usuario).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mapas> listarByNotUsuario(Usuarios usuario) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Mapas m where m.usuario != :usuario");
		
		return q.setParameter("usuario",usuario).list();
	}
}
