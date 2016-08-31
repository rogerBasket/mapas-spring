package com.roger.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roger.hibernate.dto.Usuarios;

@Controller
@RequestMapping("/")
public class NavegacionController {

	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("registro")
	public String registro() {
		return "registro";
	}
	
	@RequestMapping("home")
	public String home(HttpSession session) {
		Usuarios usuario = (Usuarios)session.getAttribute("usuario");
		
		StringBuilder pagina = new StringBuilder();
		pagina.append("redirect:");
		
		if(usuario != null) {
			if(usuario.getPerfil().getDescripcion().equals("administrador"))
				return pagina.append("admin").toString();
			else
				return pagina.append("usuario").toString();
		}
		
		return pagina.append("index").toString();
	}
	
	@RequestMapping("salir")
	public String salir(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
