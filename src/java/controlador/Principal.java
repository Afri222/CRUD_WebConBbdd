package controlador;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Crud;
import modelo.Empleado;

@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class Principal extends HttpServlet {

    String opcion = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("variable", request.getParameter("variable"));
        sesion.setAttribute("fase", "fase1");
        opcion = (String) sesion.getAttribute("variable");
        String cancelado = (String) sesion.getAttribute("cancelar");
        ArrayList<Empleado> listado = new ArrayList<>();
        Empleado emp;
        
        if ("true".equalsIgnoreCase(cancelado)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
        switch (opcion) {
            case "1":   // Altas
                request.getRequestDispatcher("/formAltas.jsp").forward(request, response);
                break;

            case "2":
                request.getRequestDispatcher("/formBajas.jsp").forward(request, response);
                break;

            case "3":
                request.getRequestDispatcher("/formAct.jsp").forward(request, response);
                break;
            case "4":
                emp = Crud.consultaRegistro(0);
                request.getRequestDispatcher("").forward(request, response);
                break;
            case "5":
                listado = Crud.mostrarListado();
                request.getRequestDispatcher("formConsultas.jsp").forward(request, response);
                break;
            case "cancelar":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

        }
        }
    }
}