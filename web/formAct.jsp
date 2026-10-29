<%-- 
    Document   : formAct
    Created on : 26-oct-2026, 8:59:10
    Author     : afric
--%>
<%@page import="modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controlador.Segundo" %>
<%@ page import="modelo.Empleado" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Empleados</title>
    </head>
    <body>
        <h1>Formulario de Actualización</h1>
        <%
            HttpSession sesion = request.getSession();
            Empleado emp = (Empleado) sesion.getAttribute("empleado");
        %>
        <hr>

        <input type="hidden" id="fase" value="fase2" name="fase">
        <%
            if (emp != null) {
        %>
        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="false">

            <table border="1" cellpadding="6" cellspacing="0">
                <td><label for="nombre">Nombre:</label></td>
                <td><input type="text" name="nombre" id="nombre" maxlength="10" value="${emp.getEname()}" required></td>
                </tr>
                <tr>
                    <td><label for="trabajo">Puesto / Trabajo:</label></td>
                    <td><input type="text" name="trabajo" id="trabajo" maxlength="9" value=${emp.getJob()} required></td>
                </tr>
                <tr>
                    <td><label for="manager">Nº Manager:</label></td>
                    <td><input type="number" step="any" name="manager" min="1" max="9999" maxlength="11" id="manager" value=${emp.getMgr()}></td>
                </tr>
                <tr>
                    <td><label for="fechaContratado">Fecha Contratación:</label></td>
                    <td><input type="date" name="fechaContratado" id="fechaContratado" value=${emp.getHireDate()} required></td>
                </tr>
                <tr>
                    <td><label for="salario">Salario:</label></td>
                    <td><input type="number" step="0.01" name="salario" min="1" maxlength="11" id="salario" value=${emp.getSal()} required></td>
                </tr>
                <tr>
                    <td><label for="comision">Comisión:</label></td>
                    <td><input type="number" step="0.01" name="comision" id="comision" maxlength="11" placeholder=${emp.getComm()}></td>
                </tr>
                <tr>
                    <td><label for="numDepartamento">Nº Departamento:</label></td>
                    <td><input type="number" step="any" name="numDepartamento" min="1" max="9999" maxlength="11" id="numDepartamento" placeholder=${emp.getDeptno()} required></td>
                </tr>
            </table>
            <br/>
            <div>
                <button type="submit" >Actualizar campo/s</button>
                <button type="reset">Limpiar campos</button>
            </div>
        </form>
        <%
            } else {
        %> No se pudo leer el registro. <% }%>
        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="true">
            <button type="submit" name="volver"><label for="volver">Volver</label></button>
        </form>
    </body>
</html>

<%-- (int empno, String ename, String job, Integer mgr, Date hireDate, double sal, Integer comm, int deptno) --%>