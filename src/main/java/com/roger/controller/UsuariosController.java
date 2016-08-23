package com.roger.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String registro(@ModelAttribute Usuarios usuario, HttpSession session) {
		String pagina = (String)usuariosServicesImpl.registroUsuario(usuario);
		session.setAttribute("usuario",usuario);
		
		return pagina;
	}
}
