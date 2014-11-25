<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.concesionario.modelo.Coche"%>
<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
 <h1>CONCESIONARIO SUCOCHE</h1>
     <!--  Recuperar los datos del request.        -->
    <%
        ArrayList<Coche> temporal =(ArrayList<Coche>) request.getAttribute("listado");
    %>
    
    <!--   moptrar los datos de la consulta (arraylist) -->
    <table>
        <tr> 
            <th>Id</th>
            <th>Matricula</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Color</th>
            <th>numCaballos</th>
            <th>Marchas</th>
        </tr>
         <% for(Coche fila: temporal) { %>
       
         <tr>
            <td><%=fila.getId()%></td>
            <td><%=fila.getMatricula()%></td>
            <td><%=fila.getMarca() %></td>
            <td><%=fila.getModelo() %></td>
            <td><%=fila.getColor() %></td>
            <td><%=fila.getNumCaballos() %></td>
            <td><%=fila.isMarchas()?"SÍ":"NO"  %></td>
         </tr>
        <%} %>
    </table>
    <a href="index.html">Ir a inicio</a>
</body>
</html>