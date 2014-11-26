<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.concesionario.modelo.Coche"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Individual</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
<form action="Procesar" method="get">
 <% Coche coche = (Coche)request.getAttribute("coche"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Matricula</th>
      <th>Marca</th>
      <th>Modelo</th>
      <th>Color</th>
      <th>NumCaballos</th>
      <th>Marchas</th> 
    </tr>
   <tr>
      <td><input type="text" name="id" value="<%=coche.getId() %>" readonly="readonly"/></td>  
      <td><input type="text" name="matricula" required="required" maxlength="6" value="<%=coche.getMatricula() %>"/></td>
      <td><input type="text" name="marca" value="<%=coche.getMarca() %>"/></td>
      <td><input type="text" name="modelo" value="<%=coche.getModelo() %>"/></td>
      <td><input type="text" name="color" value="<%=coche.getColor() %>"/></td>
      <td><input type="text" name="numCaballos" min="100" max="1000" required="required" step="50" value="<%=coche.getNumCaballos() %>"/></td>
      <td><input type="checkbox" name="marchas" value=""
             <%=coche.isMarchas()?"checked='checked'":"" %>/></td>
  </tr>
</table>
 <input class="botones" type="submit" value="Borrar" id="borrar" name="borrar"/>
 <input class="botones" type="submit" value="Actualizar" id="actualizar" name="actualizar"/>
</form>

 
  <a href="index.html">Ir a inicio</a>
</body>
</html>
      

        