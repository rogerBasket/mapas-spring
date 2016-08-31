package com.roger.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roger.hibernate.dto.Mapas;
import com.roger.hibernate.dto.Usuarios;
import com.roger.services.UsuariosServices;

@Controller
@RequestMapping("/usuarios/")
public class UsuariosController {
	@Autowired
	private UsuariosServices usuariosServicesImpl;
	
	@RequestMapping("login")
	public String login(@ModelAttribute Usuarios usuario, HttpSession session) {
		Object o[] = (Object [])usuariosServicesImpl.loginUsuario(usuario);
		Usuarios u = (Usuarios)o[0];
		String pagina = (String)o[1];
		
		if(!pagina.equals("error") && !pagina.equals("login"))
			session.setAttribute("usuario",u);
		
		return pagina;
	}
	
	@RequestMapping("registro")
	public String registro(@ModelAttribute Usuarios usuario, Model model) {
		String pagina = (String)usuariosServicesImpl.registroUsuario(usuario);
		model.addAttribute("usuario",usuario);
		
		return pagina;
	}
	
	@RequestMapping(value = "nuevoMapa", method = RequestMethod.GET)
	public String nuevoMapa() {
		return "nuevo_mapa";
	}
	
	@RequestMapping(value = "listarMapas", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String listarMapas(HttpSession session, Model model) {
		Usuarios usuario = (Usuarios)session.getAttribute("usuario");
		//System.out.println(usuario);
		
		Object o[] = (Object [])usuariosServicesImpl.mapasUsuario(usuario);
		List<Mapas> l = (List<Mapas>)o[0];
		String pagina = (String)o[1];
		
		model.addAttribute("listaMapas",l);
		
		return pagina;
	}
	
	@RequestMapping(value = "contribuciones", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String contribuciones(HttpSession session, Model model) {
		Usuarios usuario = (Usuarios)session.getAttribute("usuario");
		System.out.println(usuario);
		
		Object o[] = (Object [])usuariosServicesImpl.contribuciones(usuario);
		List<Mapas> l = (List<Mapas>)o[0];
		String pagina = (String)o[1];
		
		model.addAttribute("listaMapas",l);
		
		return pagina;
	}
	
	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String perfil() {
		return "perfil";
	}
}
