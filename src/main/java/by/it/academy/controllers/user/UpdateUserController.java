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
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        userService.updateUser(name, surname, age);
        req.getRequestDispatcher(USER_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}




