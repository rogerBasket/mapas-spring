package com.roger.hibernate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roger.hibernate.dao.PerfilesDAO;
import com.roger.hibernate.dto.Perfiles;

@Repository
public class PerfilesDAOImpl implements PerfilesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void create(Perfiles perfil) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public Perfiles read(Perfiles perfil) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		return (Perfiles)session.get(Perfiles.class,perfil.getIdPerfil());
	}
	
	@SuppressWarnings({"unchecked","unused"})
	public List<Perfiles> readId(Perfiles perfil) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		
		Transaction t = session.beginTransaction();
		
		Query q = session.createQuery("from Perfiles p where p.idPerfil = :idPerfil");
		
		return q.setInteger("idPerfil",perfil.getIdPerfil()).list();
	}
	
	public void update(Perfiles perfil) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public void delete(Perfiles perfil) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(perfil);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings({"unchecked","unused"})
	public List<Perfiles> listar() {
		Session session = sessionFactory.getCurrentSession();
		
		Transaction t = session.beginTransaction();
		
		Query q = session.createQuery("from Perfiles");
		
		return q.list();
	}
}
