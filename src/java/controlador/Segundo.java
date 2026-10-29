package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Crud;
import modelo.Empleado;

@WebServlet(name = "segundo", urlPatterns = {"/segundo"})
public class Segundo extends HttpServlet {

    String mensaje = "";
    HttpSession sesion;
    String opcion;
    int id, manager, salario, comision, numDepartamento, contCookie;
    String nombre, trabajo;
    Date fechaContrato;
    boolean testigoActualizar = false;
    String fase;
    Empleado emp;
    // Cookie cookieNumOp, cookieLastOp;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        sesion = request.getSession();
        opcion = (String) sesion.getAttribute("variable");
        fase = (String) sesion.getAttribute("fase");

        Cookie[] cookies = request.getCookies();
        Cookie contador = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("contador".equals(c.getName())) {
                    contador = c;
                    break;
                }
            }
        }
        if (contador == null) {
            contador = new Cookie("contador", "0");
        }

        contador.setValue(Integer.parseInt(contador.getValue()) + 1 + "");
        response.addCookie(contador);

        switch (opcion) {
            case "1":
                id = Integer.parseInt(request.getParameter("numEmpleado"));
                nombre = request.getParameter("nombre");
                trabajo = request.getParameter("trabajo");
                manager = Integer.parseInt(request.getParameter("manager"));
                fechaContrato = Date.valueOf(request.getParameter("fechaContratado"));
                salario = Integer.parseInt(request.getParameter("salario"));
                comision = Integer.parseInt(request.getParameter("comision"));
                numDepartamento = Integer.parseInt(request.getParameter("numDepartamento"));

                mensaje = Crud.darAlta(id, nombre, trabajo, manager, fechaContrato, salario, comision, numDepartamento);
                sesion.setAttribute("mensaje", mensaje);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "2":
                id = Integer.parseInt(request.getParameter("numEmpleado"));
                mensaje = Crud.darBaja(id);
                sesion.setAttribute("mensaje", mensaje);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "3":
                if (fase.equals("fase1")) {
                    id = Integer.parseInt(request.getParameter("numEmpleado"));
                    emp = Crud.consultaRegistro(id);
                    sesion.setAttribute("empleado", emp);
                    sesion.setAttribute("fase", "fase2");

                    request.getRequestDispatcher("/formAct.jsp").forward(request, response);
                } else {
                    nombre = request.getParameter("nombre");
                    trabajo = request.getParameter("trabajo");
                    manager = Integer.parseInt(request.getParameter("manager"));
                    fechaContrato = Date.valueOf(request.getParameter("fechaContratado"));
                    salario = Integer.parseInt(request.getParameter("salario"));
                    comision = Integer.parseInt(request.getParameter("comision"));
                    numDepartamento = Integer.parseInt(request.getParameter("numDepartamento"));
                    mensaje = Crud.actualizarRegistro(id, nombre, trabajo, manager, fechaContrato, salario, comision, numDepartamento);
                    sesion.setAttribute("mensaje", mensaje);

                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }

                break;
            case "4":
                /* mensaje = Crud.mostrarListado(); // Hecho en "Principal" (Servlet)
                sesion.setAttribute("mensaje", mensaje); */

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "5":
                /* id = Integer.parseInt(request.getParameter("numEmpleado"));
                mensaje = Crud.consultaRegistro(id); // Hecho en "Principal" (Servlet)
                mensaje = "";
                sesion.setAttribute("mensaje", mensaje); */

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
        }
    }
}
