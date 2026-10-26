package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Crud;


@WebServlet(name = "segundo", urlPatterns = {"/segundo"})
public class Segundo extends HttpServlet {

    String mensaje;
    HttpSession sesion;
    String opcion;
    int id, manager, salario, comision, numDepartamento;
    String nombre, trabajo;
    Date fechaContrato;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        sesion = request.getSession();
        opcion = (String)sesion.getAttribute("variable");
        
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
                
                request.getRequestDispatcher("").forward(request, response);
                break;
            case "3":
                request.getRequestDispatcher("").forward(request, response);
                break;
            case "4":
                request.getRequestDispatcher("").forward(request, response);
                break;
        }
    }
}