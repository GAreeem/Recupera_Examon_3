package controllers.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.user.DaoUser;
import models.user.Incidencia;
import models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "users",urlPatterns = {
        "/user/login",
        "/user/logout",
        "/user/auth",
        "/user/index",
        "/user/user",
        "/user/crear-incidencias",
        "/user/guardar-incidencia",
        "/charge/aceptar-soli",
        "/charge/rechazar-soli"

})
public class ServletUser extends HttpServlet {
    private String action;
    private String redirect = " ";
    private String username;
    private String password;
    private String role;
    private String titulo;
    private String descripcion;
    private String estado;
    private Long id;
    User user;
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action=req.getServletPath();
        switch (action){

            case "/user/index":
                List<Incidencia> incidencias = new DaoUser().BuscIncidencias();
                req.setAttribute("incidencias",incidencias);
                redirect = "/views/user/index.jsp";
                break;

            case "/user/crear-incidencias":
                redirect = "/views/user/incidencia.jsp";
                break;

            case "/user/user":
                redirect = "/index.jsp";
                break;

            case "/user/logout":
                try {
                    HttpSession session = req.getSession(false);
                    if (session != null) {
                        session.invalidate();
                    }
                    redirect = "/user/user?result=true&message=" + URLEncoder
                            .encode("Sesión cerrada correctamente", StandardCharsets.UTF_8);
                } catch (Exception e) {
                    break;
                    }

            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action){

            case "/user/guardar-incidencia":
                titulo = req.getParameter("titulo");
                descripcion = req.getParameter(("descripcion"));
                estado = req.getParameter("estado");

                Incidencia incidencia = new Incidencia(0L,titulo, descripcion, estado);
                boolean result = new DaoUser().GuardarIncidencia(incidencia);
                if (result){
                    redirect = "/user/index?result= " + result + "&message=" + URLEncoder.encode("¡Éxito! Usuario registrado correctamente.", StandardCharsets.UTF_8);

                }else{
                    redirect = "/user/index?result= " + result + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                }
                break;

            case "/user/auth":
                username = req.getParameter("username");
                password = req.getParameter("password");
                try {
                    user = new DaoUser()
                            .loadUserByUsernameAndPassword(username, password);
                    if (user != null) {
                        session = req.getSession();
                        session.setAttribute("user", user);
                        switch (user.getRole()) {
                            case "ADMIN_ROLE":
                                redirect = "/admin/index";
                                break;
                            case "CHARGE_ROLE":
                                redirect = "/charge/index";
                                break;
                            case "USER_ROLE":
                                redirect = "/user/index";
                                break;
                        }
                    } else {
                        throw new Exception("Credentials mismatch");
                    }
                } catch (Exception e) {
                    redirect = "/user/user?result=false&message=" + URLEncoder.encode("Usuario y/o contraseña incorrecta", StandardCharsets.UTF_8);
                }
                break;

            case "/charge/aceptar-soli":
                id = Long.parseLong(req.getParameter("id"));
                System.out.println(id);
                if (new DaoUser().IncidenciaAprobada(id)) {
                    redirect = "/charge/index?result=" + true + "&message=" + URLEncoder.encode("Usuario aceptado correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/charge/index?result=" + false + "&message=" + URLEncoder.encode("Error al aceptar el usuario", StandardCharsets.UTF_8);
                }
                break;

            case "/charge/rechazar-soli":
                id = Long.parseLong(req.getParameter("id"));
                System.out.println(id);
                if (new DaoUser().IncidenciaDenegada(id)) {
                    redirect = "/charge/index?result=" + true + "&message=" + URLEncoder.encode("Usuario rechazado correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/charge/index?result=" + false + "&message=" + URLEncoder.encode("Error al rechazar el usuario", StandardCharsets.UTF_8);
                }
                break;
            default:
                redirect = "/user/user";
        }
        resp.sendRedirect(req.getContextPath() + redirect);

    }
}
