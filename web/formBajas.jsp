<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario de Bajas</title>
    </head>
    <body>
        <h1>Formulario de Bajas</h1>
        <hr>

        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="false">
            <table border="1" cellpadding="6" cellspacing="0">
                <tr>
                    <td><label for="numEmpleado">Nº Empleado:</label></td>
                    <td><input type="number" step="any" name="numEmpleado" min="1" max="9999" maxlength="11" id="numEmpleado" required></td>
                </tr>
            </table>

            <br>

            <button type="submit">Baja</button>
            <button type="reset">Limpiar campos</button>
        </form>

        <form action="segundo" method="post">
            <input type="hidden" name="cancelar" value="true">
            <button type="submit" name="volver"><label for="volver">Volver</label></button>
        </form>
    </body>
</html>