package by.it.academy.controllers.user;


import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/user/authorize", loadOnStartup = 1)
public class AuthorizeUserController extends HttpServlet {
    private static final String USER_PAGE = "/pages/simples/authorizeUser.jsp";
    private UserService userService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute("userService", userService);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        userService.authorizeUser(user);
        req.getRequestDispatcher(USER_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        userService = new UserServiceImpl(new UserRepositoryImpl());
        config.getServletContext().setAttribute("userService", userService);
    }
}

