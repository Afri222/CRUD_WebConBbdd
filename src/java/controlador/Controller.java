package controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author afric
 */
@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class Controller extends HttpServlet {
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion = request.getParameter("indice");
        
        switch (opcion) {
            case "1":
                request.getRequestDispatcher("formAltas.jsp").forward(request, response);
                break;
            case "2":
                request.getRequestDispatcher("formEliminar.jsp").forward(request, response);
                break;
            case "3":
                request.getRequestDispatcher("formModificar.jsp").forward(request, response);
                break;
            case "4":
                request.getRequestDispatcher("formMostrar.jsp").forward(request, response);
                break;
            case "5":
                request.getRequestDispatcher("formMostrar.jsp").forward(request, response);
                break;
        }
        
    }
}
