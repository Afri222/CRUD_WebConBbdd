<%-- 
    Document   : formConsultas
    Created on : 26-oct-2026, 8:58:31
    Author     : afric
--%>

<%@page import="modelo.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de consultas</title>
    </head>
    <body>
        
        <h1>Contenido</h1>
        
        <%
        HttpSession sesion = request.getSession();
        ArrayList<Empleado> listado = (ArrayList<Empleado>) sesion.getAttribute("listado");
        %>
        
        <% if (listado != null) { %>
        <table>
            <tr>
                <th> Empno </th>
                <th> Ename </th>
                <th> Job </th>
                <th> Mgr </th>
                <th> Hire Date </th>
                <th> Sal </th>
                <th> Comm </th>
                <th> Deptno </th>
                
            </tr>
            <% for(Empleado e:listado) {%>
            <tr>
                <td><%= e.getEmpno() %></td>
                <td><%= e.getEname()%></td>
                <td><%= e.getJob()%></td>
                <td><%= e.getMgr()%></td>
                <td><%= e.getHireDate()%></td>
                <td><%= e.getSal()%></td>
                <td><%= e.getComm()%></td>
                <td><%= e.getDeptno()%></td>
                
            </tr>
            <% } %>
            
        </table>
        <% } else {%> No hay registros disponibles <% } %>
        
        <form action="principal" method="post">
            <input type="button" onclick="enviarFormulario(cancelar)" value="Volver"><br>
            <%-- <button type="sumbit" value="volver"><label for="volver">Volver</label></button> --%>
        </form>
        <script>
            function enviarFormulario(valor) {
                document.getElementById("botonElegido").value = valor;
                document.getElementById("menuPrincipal").submit();
            }
        </script>
    </body>
</html>
