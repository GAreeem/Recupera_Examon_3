package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.admin.DaoAdmin;
import models.user.DaoUser;
import models.user.Incidencia;
import models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "admins", urlPatterns = {
        "/admin/index",
        "/admin/aceptar-soli",
        "/admin/rechazar-soli"
})
public class ServletAdmin extends HttpServlet {
    private String action;
    private String redirect = "/admin/index";
    private Long id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action){
            case "/admin/index":
                List<Incidencia> incidencias = new DaoAdmin().BuscIncidenciasAprobadas();
                req.setAttribute("incidencias",incidencias);
                redirect = "/views/admin/index.jsp";
                break;
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action){
            case "/admin/aceptar-soli":
                id = Long.parseLong(req.getParameter("id"));
                if (new DaoAdmin().IncidenciaAprobada(id)) {
                    redirect = "/admin/index?result=" + true + "&message=" + URLEncoder.encode("Solicitud aprobada correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/admin/index?result=" + false + "&message=" + URLEncoder.encode("Error al aceptar la solicitud", StandardCharsets.UTF_8);
                }
                break;

            case "/admin/rechazar-soli":
                id = Long.parseLong(req.getParameter("id"));
                System.out.println(id);
                if (new DaoAdmin().IncidenciaDenegada(id)) {
                    redirect = "/admin/index?result=" + true + "&message=" + URLEncoder.encode("Solicitud rechazada correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/admin/index?result=" + false + "&message=" + URLEncoder.encode("Error al Rechazar la Solucitud", StandardCharsets.UTF_8);
                }
                break;
            default:
                redirect = "/admin/index";
        }
        resp.sendRedirect(req.getContextPath() + redirect);

    }

}
