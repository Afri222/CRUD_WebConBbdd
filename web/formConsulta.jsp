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
        <title>Formulario de consulta</title>
    </head>
    <body>
        <h1>Contenido</h1>

        <%
            HttpSession sesion = request.getSession();
            Empleado e = (Empleado) sesion.getAttribute("empleado");
        %>

        <% if (e != null) { %>
        <table border="9" cellpadding="3">
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
            <tr>
                <td><%= e.getEmpno()%></td>
                <td><%= e.getEname()%></td>
                <td><%= e.getJob()%></td>
                <td><%= e.getMgr()%></td>
                <td><%= e.getHireDate()%></td>
                <td><%= e.getSal()%></td>
                <td><%= e.getComm()%></td>
                <td><%= e.getDeptno()%></td>
            </tr>

        </table>
        <% } else {%> No hay registro disponible. <% }%>
        
        <br>
        
        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="true">
            <button type="submit" name="volver"><label for="volver">Volver</label></button>
        </form>
    </body>
</html>
