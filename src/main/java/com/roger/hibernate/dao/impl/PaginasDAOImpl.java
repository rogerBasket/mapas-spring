package com.roger.hibernate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roger.hibernate.dao.PaginasDAO;
import com.roger.hibernate.dto.Paginas;

@Repository
public class PaginasDAOImpl implements PaginasDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Paginas pagina) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public Paginas read(Paginas pagina) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		return (Paginas)session.get(Paginas.class,pagina.getIdPagina());
	}
	
	public void update(Paginas pagina) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	public void delete(Paginas pagina) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(pagina);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
			throw he;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Paginas> listar() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Paginas");
		
		return q.list();
	}
}
