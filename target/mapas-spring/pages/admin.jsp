<%@ page language="java" contentType="text/html"%>
<%@page import="java.util.List" %>
<%@page import="com.roger.hibernate.dto.Usuarios"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mapbici</title>
		<link rel="stylesheet" href="estilos/estilo.css" type="text/css"/>
		<link rel="stylesheet" href="estilos/tabla.css" type="text/css"/>
		
		<!-- slides -->
		<!-- add styles -->
		<link rel="stylesheet" href="estilos/slides.css" type="text/css"/>
		
		<!-- add scripts -->
		<script src="calendario-js/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/slider.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
	</head>
	<body>
		<div id="contiene">
			<div id="datos">
				<div id="titulo">
					<h1>MapBici</h1>
					<a href="HomeAction"><img class="logo" src="images/logo.png"/></a>
				</div>
				<div id="menu">
					<ul id="navega">
						<li><a href="HomeAction">Home</a></li>
					</ul>
					<ul id="salir">
						<li><a href="SalirAction">Salir</a></li>
					</ul>
				</div>
			</div>
			
			<div id="slides-container">
		        <div id="slides">
					<div>
						<div class="slide-image"><img src="images/bici1.png"/></div>
						<div class="slide-text">
						    <h2>Costo de la bicicleta</h2>
						    <p>El precio de una bici es accesible para la poblacion, no consume nada, no tienes que pagar un seguro, no hay que hacerle ningun arreglo, no te ponen multas de aparcamiento ni de velocidad.</p>
						</div>
					</div>
					 
					<div>
						<div class="slide-image"><img src="images/bici2.png"/></div>
						<div class="slide-text">
						    <h2>La Bici no contamina</h2>
						    <p>Contribuye con el planeta, la bici es el medio de transporte mas ecologico que puedes utilizar en la ciudad. Ahorra emisiones de CO2 innecesarias. Por cada 3 kilometros en bici, se ahorra 1 kilo de CO2.</p>
						</div>
					</div>
					 
					<div>
						<div class="slide-image"><img src="images/bici3.png"/></div>
						<div class="slide-text">
						    <h2>Ir en bici es rapido</h2>
						    <p>Para distancias de 7 kilometros o menos, es mas rapido ir en bici que en cualquier otro transporte. No tardaras en esperar al transporte publico ni en estacionarla.</p>
						</div>
					</div>
				</div>
		        <div class="controls"><span class="jFlowNext"><span>Next</span></span><span class="jFlowPrev"><span>Prev</span></span></div>        
		        <div id="myController" class="hidden"><span class="jFlowControl">Slide 1</span><span class="jFlowControl">Slide 1</span><span class="jFlowControl">Slide 1</span></div>
		    </div>
			
			<div id="texto">
				<div id="box">
					<table>
						<tr>
							<th>Usuario</th>
							<th>Visualizar</th>
							<th>Eliminar</th>
						<tr>
					<%
						List<Usuarios> usuarios = (List<Usuarios>)session.getAttribute("listaUsuarios");
						for(Usuarios u: usuarios) {
							String ver = "VerUsuarioAction?idUsuario=" + u.getIdUsuario();
							String borrar= "BorrarUsuarioAction?idUsuario=" + u.getIdUsuario();
					%>
						<tr>
							<td><%=u.getUser() %></td>
							<td><a href=<%=ver %>>ver</a></td>
							<td><a href=<%=borrar %>>borrar</a></td>
						</tr>
					<%
						}
					%>
					</table>
				</div>
			</div>
		</div>	
	</body>
</html>