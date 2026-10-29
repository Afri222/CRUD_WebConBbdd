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
        <h3>Introduce el identificador del empleado:</h3>
        <hr>

        <form action="segundo" method="post">
            <table border="1" cellpadding="6" cellspacing="0">

                <td><label for="nombre">Nombre:</label></td>
                <td><input type="text" name="nombre" id="nombre" placeholder="${emp.getEname()}" required></td>
                </tr>
                <tr>
                    <td><label for="trabajo">Puesto / Trabajo:</label></td>
                    <td><input type="text" name="trabajo" id="trabajo" placeholder=${emp.getJob()} required></td>
                </tr>
                <tr>
                    <td><label for="manager">Nº Manager:</label></td>
                    <td><input type="number" step="any" name="manager" id="manager" placeholder=${emp.getMgr()}></td>
                </tr>
                <tr>
                    <td><label for="fechaContratado">Fecha Contratación:</label></td>
                    <td><input type="date" name="fechaContratado" id="fechaContratado" placeholder=${emp.getHireDate()} required></td>
                </tr>
                <tr>
                    <td><label for="salario">Salario:</label></td>
                    <td><input type="number" step="0.01" name="salario" id="salario" placeholder=${emp.getSal()} required></td>
                </tr>
                <tr>
                    <td><label for="comision">Comisión:</label></td>
                    <td><input type="number" step="0.01" name="comision" id="comision" placeholder=${emp.getComm()}></td>
                </tr>
                <tr>
                    <td><label for="numDepartamento">Nº Departamento:</label></td>
                    <td><input type="number" step="any" name="numDepartamento" id="numDepartamento" placeholder=${emp.getDeptno()} required></td>
                </tr>
            </table>
            <br/>
            <div>
                <button type="submit" >ACTUALIZAR</button>
                <button type="reset">Limpiar campos</button>
            </div>
        </form>
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

<%-- (int empno, String ename, String job, Integer mgr, Date hireDate, double sal, Integer comm, int deptno) --%>