package by.it.academy.filters;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/user/authorize"})
public class AuthorizationFilter extends HttpFilter {
    private static final long serialVersionUID = 5992383557775358650L;
    private static final String ADMIN_PAGE = "/pages/role/adminPage.jsp";
    private static final String USER_PAGE = "/pages/role/userPage.jsp";
    private UserService userService;

    @SneakyThrows
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        if (null != session && null != session.getAttribute("userType")) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType == userType.ADMIN) {
                req.getRequestDispatcher(ADMIN_PAGE).forward(req, res);
            } else if (userType == userType.USER) {
                req.getRequestDispatcher(USER_PAGE).forward(req, res);
            } else {
                List<User> users = userService.readUser();
                users.stream()
                        .filter(user -> user.getLogin().equals(req.getParameter("login")))
                        .findFirst()
                        .ifPresent(user -> session.setAttribute("userType", user.getUserType()));
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }

    @Override
    public void destroy() {
    }
}

