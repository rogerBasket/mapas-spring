package com.roger.hibernate.dao;

import java.util.List;

import com.roger.hibernate.dto.Paginas;

public interface PaginasDAO {
	public void create(Paginas pagina);
	public Paginas read(Paginas pagina);
	public void update(Paginas pagina);
	public void delete(Paginas pagina);
	public List<Paginas> listar();
}
