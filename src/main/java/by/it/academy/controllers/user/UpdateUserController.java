package by.it.academy.controllers.user;

import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/user/update")
public class UpdateUserController extends HttpServlet {

    private static final String USER_PAGE = "/pages/simples/updateUser.jsp";
    private UserService userService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String newLogin = req.getParameter("newLogin");
        String newPassword = req.getParameter("newPassword");
        String id = req.getParameter("id");
        userService.updateUser(Long.valueOf(id), newLogin, newPassword);
        req.getRequestDispatcher(USER_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}




