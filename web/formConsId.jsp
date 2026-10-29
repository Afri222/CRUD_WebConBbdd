<%-- 
    Document   : formConsId
    Created on : 29-oct-2026, 21:56:56
    Author     : afric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de consulta</title>
    </head>
    <body>
        <h1>Formulario consulta</h1>
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
            <br/>
            <div>
                <button type="submit" >Buscar</button>
                <button type="reset">Limpiar campo</button>
            </div>
        </form>
        <br>
        <form method="post" action="segundo">
            <input type="hidden" name="cancelar" value="true">
            <button type="submit">Cancelar</button>
        </form>

    </body>
</html>
