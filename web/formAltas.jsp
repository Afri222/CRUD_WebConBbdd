<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@page import="controlador.Segundo" %> --%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Empleados</title>
</head>
<body>
    <h1>Formulario de Altas</h1>
    </hr>
    <h3>Introduce los datos del empleado:</h3>
    </hr>
    <form action="segundo" method="post">
        <table border="1" cellpadding="6" cellspacing="0">
            <tr>
                <td><label for="numEmpleado">Nº Empleado:</label></td>
                <td><input type="number" step="any" min="1" name="numEmpleado" id="numEmpleado" required></td>
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
                <td><input type="number" step="any" min="1" name="numDepartamento" id="numDepartamento" required></td>
            </tr>
        </table>

        <br/>

        <div>
            <button type="submit" >Insertar un empleado</button>
            <button type="reset">Limpiar campos</button>
        </div>
    </form>
    
    
    <form action="" method="post">
        <input type="hidden" name="cancelar" value="true">
        <button type="submit" name="volver"><label for="volver">Volver</label></button>
        <%-- <input type="button" onclick="enviarFormulario(cancelar)" value="Volver"> --%>
    </form>
    
        <%-- <script>
            function enviarFormulario(valor) {
                document.getElementById("botonElegido").value = valor;
                document.getElementById("menuPrincipal").submit();
            }
    </script> --%>
</body>
</html>