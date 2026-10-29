<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Bajas</title>
    </head>
    <body>
        <h1>Formulario de Bajas</h1>
        
        
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