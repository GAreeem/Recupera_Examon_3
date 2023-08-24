package controllers.charge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Role.Role;
import models.charge.DaoCharge;
import models.user.Incidencia;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "charges", urlPatterns = {
        "/charge/index"
})
public class ServletCharge extends HttpServlet {
    private String action;
    private String redirect = "/charge/index";
    private String id;
    private String titulo;
    private String descripcion;
    private String estado;
    Role role;
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action=req.getServletPath();
        switch (action){
            case "/charge/index":
                List<Incidencia> incidencias = new DaoCharge().BuscIncidenciaPendiente();
                req.setAttribute("incidencias",incidencias);
                redirect = "/views/charge/index.jsp";
                break;

            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req,resp);
    }
}
