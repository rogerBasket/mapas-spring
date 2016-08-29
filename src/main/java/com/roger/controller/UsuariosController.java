package com.roger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roger.hibernate.dto.Mapas;
import com.roger.hibernate.dto.Usuarios;
import com.roger.services.UsuariosServices;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/usuarios/")
public class UsuariosController {
	@Autowired
	private UsuariosServices usuariosServicesImpl;
	
	@RequestMapping("login")
	public String login(@ModelAttribute Usuarios usuario, Model model) {
		Object o[] = (Object [])usuariosServicesImpl.loginUsuario(usuario);
		Usuarios u = (Usuarios)o[0];
		String pagina = (String)o[1];
		
		if(!pagina.equals("error") && !pagina.equals("login"))
			model.addAttribute("usuario",u);
		
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
	public String listarMapas(@ModelAttribute("usuario") Usuarios usuario, Model model) {
		Object o[] = (Object [])usuariosServicesImpl.mapasUsuario(usuario);
		List<Mapas> l = (List<Mapas>)o[0];
		String pagina = (String)o[1];
		
		model.addAttribute("listaMapas",l);
		
		return pagina;
	}
	
	@RequestMapping(value = "contribuciones", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String contribuciones(@ModelAttribute("usuario") Usuarios usuario, Model model) {
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
