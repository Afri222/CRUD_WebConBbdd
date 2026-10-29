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
            Empleado e = (Empleado) sesion.getAttribute("empleado");
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
            <% for (Empleado e2 : listado) {%>
                <tr>
                    <td><%= e2.getEmpno()%></td>
                    <td><%= e2.getEname()%></td>
                    <td><%= e2.getJob()%></td>
                    <td><%= e2.getMgr()%></td>
                    <td><%= e2.getHireDate()%></td>
                    <td><%= e2.getSal()%></td>
                    <td><%= e2.getComm()%></td>
                    <td><%= e2.getDeptno()%></td>
                </tr>
            <% } %>

        </table>
        <% } else if (e != null) { %>
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
        <% } else {%> No hay registros disponibles <% }%>

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
