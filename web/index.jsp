<%-- 
    Document   : index
    Created on : 20-oct-2026, 13:14:56
    Author     : afric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de contraseñas</title>
    </head>
    <body>
        <h1>Gestor de contraseñas - CRUD</h1>
        
        <hr>
        
        <p> Mensaje </p>
        
        <hr><br>
        
        <h3>Elija la operación a realizar:</h3>
        <form action="Controller" method="post">
            <input type="radio" name="indice" id="aniadir" value="Añadir empleado"><label for="aniadir">Añadir un empleado</label> <br>
            <input type="radio" name="indice" id="eliminar" value="Eliminar empleado"><label for="eliminar">Eliminar un empleado</label> <br>
            <input type="radio" name="indice" id="modificar" value="Modificar empleado"><label for="modificar">Modificar un empleado</label> <br>
            <input type="radio" name="indice" id="mostrarEmpeado" value="Mostrar empleado"><label for="mostrarEmpleado">Mostrar un empleado</label> <br>
            <input type="radio" name="indice" id="mostrarTodos" value="Mostrar empleados"><label for="mostrarTodos">Mostrar todos los empleados</label> <br>
            <br>
            <input type="submit" name="enviarIndice" value="Enviar">
            <input type="reset" name="reset" value="Borrar">
        </form>
        
    </body>
</html>

<%-- <input type="radio" name="empno" value="Número del empleado"> (int empno, String ename, String job, Integer mgr, Date hireDate, double sal, Integer comm, int deptno) --%>