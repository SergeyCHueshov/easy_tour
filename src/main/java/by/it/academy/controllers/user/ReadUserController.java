package by.it.academy.controllers.user;

import by.it.academy.entities.User;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/user/read")
public class ReadUserController extends HttpServlet {

    private static final String USER_PAGE = "/pages/simples/readUser.jsp";
    private UserService userService;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_PAGE);
        List<User> users;
        users = userService.readUser();
        req.setAttribute("users", users);
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}
