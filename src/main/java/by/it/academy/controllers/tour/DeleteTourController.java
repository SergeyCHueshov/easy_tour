package by.it.academy.controllers.tour;

import by.it.academy.services.TourService;
import by.it.academy.services.TourServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tour/delete")
public class DeleteTourController extends HttpServlet {
    private static final String USER_PAGE = "/pages/simples/deleteTour.jsp";
    private TourService tourService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        tourService.deleteTour();
        req.getRequestDispatcher(USER_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        tourService = (TourServiceImpl) config.getServletContext().getAttribute("tourService");
    }
}
