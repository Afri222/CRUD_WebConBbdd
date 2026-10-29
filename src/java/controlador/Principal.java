package controlador;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Crud;
import modelo.Empleado;

@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class Principal extends HttpServlet {
    String opcion = "";
    String sinEspacios;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("variable", request.getParameter("variable"));
        sesion.setAttribute("fase", "fase1");
        opcion = (String) sesion.getAttribute("variable");
        String cancelado = (String) sesion.getAttribute("cancelar");
        ArrayList<Empleado> listado = new ArrayList<>();
        Empleado emp;
        
        Cookie contador = new Cookie("numOp", "0"); // String.valueOf(cookieNumOp.getValue() + contCookie)
        contador.setMaxAge(600);
        response.addCookie(contador);
        
        sinEspacios = Timestamp.valueOf(LocalDateTime.now()) + "";
        sinEspacios = sinEspacios.replaceAll(" ", "_");
        Cookie ultimaOperacion = new Cookie("ultimaOperacion", sinEspacios); // String.valueOf(cookieNumOp.getValue() + contCookie)
        ultimaOperacion.setMaxAge(600);
        response.addCookie(ultimaOperacion);
        
        
        /*
        if (cookieNumOp.getValue() != null) {
                        contCookie = Integer.parseInt(cookieNumOp.getValue());
                    } else {
                        contCookie = 0;
                    }
                    cookieNumOp = new Cookie("numOp", String.valueOf(cookieNumOp.getValue() + contCookie));
                    response.addCookie(cookieNumOp);

                    cookieNumOp = new Cookie("lastOp", String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
                    response.addCookie(cookieLastOp);
        */
        
        if ("true".equalsIgnoreCase(cancelado)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            switch (opcion) {
                case "1":
                    request.getRequestDispatcher("/formAltas.jsp").forward(request, response);
                    break;

                case "2":
                    request.getRequestDispatcher("/formBajas.jsp").forward(request, response);
                    break;

                case "3":
                    request.getRequestDispatcher("/formActId.jsp").forward(request, response);
                    break;
                    
                case "4":
                    request.getRequestDispatcher("formConsulta.jsp").forward(request, response);
                    break;
                    
                case "5":
                    listado = Crud.mostrarListado();
                    sesion.setAttribute("listado", listado);
                    request.getRequestDispatcher("formConsultas.jsp").forward(request, response);
                    break;
            }
        }
    }
}
