<%-- 
    Document   : formAltas
    Created on : 22-oct-2026, 10:20:17
    Author     : afric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form altas</title>
    </head>
    <body>
        <h1>Formulario de Altas</h1>
        
        <h3>Introduce los datos:</h3>
        
        <form action="ProcesoVariableServlet" method="post">
        <table border="1" cellpadding="6" cellspacing="0">
            <tr>
                <td><label for="numEmpleado">Nº Empleado:</label></td>
                <td><input type="number" <%-- step="any" --%> name="numEmpleado" id="numEmpleado" required></td> <%-- step="any" permite cualquier dígito, con o sin decimales, negativos, etc --%>
            </tr>
            <tr>
                <td><label for="nombre">Nombre:</label></td>
                <td><input type="text" name="nombre" id="nombre" required></td>
            </tr>
            <tr>
                <td><label for="trabajo">Puesto / Trabajo:</label></td>
                <td><input type="text" name="trabajo" id="trabajo" required></td>
            </tr>
            <tr>
                <td><label for="manager">Nº Manager:</label></td>
                <td><input type="number" step="any" name="manager" id="manager"></td>
            </tr>
            <tr>
                <td><label for="fechaContratado">Fecha Contratación:</label></td>
                <td><input type="date" name="fechaContratado" id="fechaContratado" required></td>
            </tr>
            <tr>
                <td><label for="salario">Salario:</label></td>
                <td><input type="number" step="0.01" name="salario" id="salario" required></td>
            </tr>
            <tr>
                <td><label for="comision">Comisión:</label></td>
                <td><input type="number" step="0.01" name="comision" id="comision"></td>
            </tr>
            <tr>
                <td><label for="numDepartamento">Nº Departamento:</label></td>
                <td><input type="number" step="any" name="numDepartamento" id="numDepartamento" required></td>
            </tr>
        </table>

        <br/>

        <div>
            <button type="submit" name="accion" value="1">Insertar un empleado</button>
            <button type="submit" name="accion" value="2" formnovalidate>Mostrar detalles de Empleados</button>
            <button type="submit" name="accion" value="3">Modificar Empleado</button>
            <button type="submit" name="accion" value="4">Despedir empleado</button>
        </div>
    </form>
</body>
</html>