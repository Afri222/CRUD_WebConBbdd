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

    String mensaje = "", opcion, fase, cancelado, nombre, trabajo, aux;
    HttpSession sesion;
    int id, salario, numDepartamento, contCookie;
    Integer manager, comision;
    Date fechaContrato;
    boolean testigoActualizar = false;
    Empleado emp;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        cancelado = (String) request.getParameter("cancelar");
        sesion = request.getSession();

        if (!"true".equalsIgnoreCase(cancelado)) {
            opcion = (String) sesion.getAttribute("variable");
            fase = (String) sesion.getAttribute("fase");

            Cookie[] cookies = request.getCookies();
            Cookie contador = null;
            Cookie ultOp = null;

            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("contador".equals(c.getName())) {
                        contador = c;
                        break;
                    }
                }
                for (Cookie c : cookies) {
                    if ("ultimaOperacion".equals(c.getName())) {
                        ultOp = c;
                        break;
                    }
                }
            }
            if (contador == null) {
                contador = new Cookie("contador", "0");
            }
            if (ultOp == null) {
                ultOp = new Cookie("ultimaOperacion", Timestamp.valueOf(LocalDateTime.now()) + "");
            }
            contador.setValue(Integer.parseInt(contador.getValue()) + 1 + "");
            ultOp.setValue((Timestamp.valueOf(LocalDateTime.now()) + "").replaceAll(" ", "_") );
            
            response.addCookie(contador);
            response.addCookie(ultOp);

            switch (opcion) {
                case "1":
                    id = Integer.parseInt(request.getParameter("numEmpleado"));
                    nombre = request.getParameter("nombre");
                    trabajo = request.getParameter("trabajo");

                    manager = new Integer(request.getParameter("manager")); // Integer.parseInt(request.getParameter("manager"));

                    fechaContrato = Date.valueOf(request.getParameter("fechaContratado"));
                    salario = Integer.parseInt(request.getParameter("salario"));

                    comision = new Integer(request.getParameter("comision")); // Integer.parseInt(request.getParameter("comision"));

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
                        
                        // if((aux = request.getParameter("manager")) != null && !aux.isEmpty()) {
                        manager = Integer.parseInt(request.getParameter("manager"));
                        // } else { }
                        
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
                    id = Integer.parseInt(request.getParameter("numEmpleado"));
                    emp = Crud.consultaRegistro(id);
                    sesion.setAttribute("empleado", emp);
                    request.getRequestDispatcher("/formConsulta.jsp").forward(request, response);
                    break;
                /* case "5":
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break; */
            }
        } else {
            sesion.setAttribute("mensaje", "");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
