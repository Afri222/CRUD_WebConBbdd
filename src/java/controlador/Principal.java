package controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class Principal extends HttpServlet {

    String opcion = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("variable", request.getParameter("variable"));
        opcion = (String) sesion.getAttribute("variable");

        switch (opcion) {
            case "1":   //Altas
                request.getRequestDispatcher("/formAltas.jsp").forward(request, response);
                break;
            case "2":
                request.getRequestDispatcher("/formBajas.jsp").forward(request, response);
                break;
            case "3":
                request.getRequestDispatcher("/formConsultas.jsp").forward(request, response);
                break;
            case "4":
                request.getRequestDispatcher("/formAct.jsp").forward(request, response);
                break;
        }
    }
}
