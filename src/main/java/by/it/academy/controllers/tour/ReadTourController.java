package by.it.academy.controllers.tour;

import by.it.academy.entities.Tour;
import by.it.academy.services.TourService;
import by.it.academy.services.TourServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/tour/read")
public class ReadTourController extends HttpServlet {

    private static final String TOUR_PAGE = "/pages/simples/readTour.jsp";
    private TourService tourService;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Tour> tours = tourService.readAllTour();
        req.setAttribute("tours", tours);
        req.getRequestDispatcher(TOUR_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        tourService = (TourServiceImpl) config.getServletContext().getAttribute("tourService");
    }
}
