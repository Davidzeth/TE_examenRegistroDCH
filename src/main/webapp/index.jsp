<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    if(session.getAttribute("listaest") == null){
        ArrayList<Estudiante> lisaux = new ArrayList<Estudiante>();
        session.setAttribute("listaest", lisaux);
    }
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>)session.getAttribute("listaest");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .contenedor {
                width: 300px; 
                margin: 0 auto; 
                padding: 20px; 
                border: 1px solid #ccc;
                text-align: center;
            }
            .titulo {
                text-align: center;
            }
        </style>    
    </head>
    <body>
        <div class="contenedor">
            <p>PRIMER PARCIAL TEM-742<br>
            Nombre: Deyvid Edilson Chambi Averanga<br>
            Carnet: 11080822</p>
        </div>
        <h1 class="titulo">Registro de calificaciones</h1>
        <button><a href="MainServlet?op=nuevo">Nuevo</a></button>
        <table border ="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>P3(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if(lista != null){
                    for(Estudiante item : lista){

            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getPriNota()%></td>
                <td><%= item.getSegNota()%></td>
                <td><%= item.getTerNota()%></td>
                <td><%= item.getTotNota()%></td>
                
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                       onclick="return(confirm('Esta seguro de eliminar?'))">Eliminar</a>
                </td>
                
            </tr>
            
            <%                    
                    }
            }
            %>
        </table>
    </body>
</html>
