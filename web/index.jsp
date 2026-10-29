<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        <h1>CRUD </h1>
        <%
            String mensaje = "";
            HttpSession sesion = request.getSession();
            mensaje = (String) sesion.getAttribute("mensaje");
            if (mensaje != null) {
        %>

        <hr>
        <h2><%=mensaje%></h2></marquee>
        <hr> 

    <%}%>
    <br/>

    <form action="principal" method="post" id="menuPrincipal">
        <div>
            <input type="button" onclick="enviarFormulario(1)" value="Alta empleado"></br></br>
            <input type="button" onclick="enviarFormulario(2)" value="Baja empleado"></br></br>
            <input type="button" onclick="enviarFormulario(3)" value="Actualizar registro"></br></br>
            <input type="button" onclick="enviarFormulario(4)" value="Datos empleado"></br></br>
            <input type="button" onclick="enviarFormulario(5)" value="Listado de empleados"></br></br>

            <input type="hidden" id="botonElegido" value="" name="variable">
        </div>
    </form>

    <script>
        function enviarFormulario(valor) {
            document.getElementById("botonElegido").value = valor;
            document.getElementById("menuPrincipal").submit();
        }
    </script>
</body>
</html>
<%-- <input type="radio" name="empno" value="Número del empleado"> (int empno, String ename, String job, Integer mgr, Date hireDate, double sal, Integer comm, int deptno) --%>