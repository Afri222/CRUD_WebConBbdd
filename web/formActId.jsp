<%-- 
    Document   : formActId
    Created on : 29-oct-2026, 21:56:15
    Author     : afric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controlador.Segundo" %> 
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Formulario actualización</title>
    </head>
    <body>
        <h1>Formulario de Actualización</h1>
        <h3>Introduce el identificador del empleado:</h3>
        <hr>

        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="false">
            <table border="1" cellpadding="6" cellspacing="0">
                <tr>
                    <td><label for="numEmpleado">Nº Empleado:</label></td>
                    <td><input type="number" step="any" min="1" max="9999" name="numEmpleado" id="numEmpleado" required></td>
                </tr>
            </table>
            <br>
            <div>
                <button type="submit" >Actualizar</button>
                <button type="reset">Limpiar campo</button>
            </div>
        </form>
    </form>
    </br>
    <form method="post" action="segundo">
        <input type="hidden" name="cancelar" value="true">
        <button type="submit">Cancelar</button>
    </form>
</body>
</html> 