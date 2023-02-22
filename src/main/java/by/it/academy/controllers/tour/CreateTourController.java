package by.it.academy.controllers.tour;

import by.it.academy.entities.Tour;
import by.it.academy.repositories.TourRepositoryImpl;
import by.it.academy.services.TourService;
import by.it.academy.services.TourServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tour/create")
public class CreateTourController extends HttpServlet {
    private static final String USER_PAGE = "/pages/simples/createTour.jsp";
    private TourService tourService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String nameTour = req.getParameter("nameTour");
        String stateTour = req.getParameter("stateTour");
        int costTour = Integer.parseInt(req.getParameter("costTour"));
        String hotel = req.getParameter("hotel");
        String additionalInf = req.getParameter("additionalInf");
        tourService.createTour(nameTour, stateTour, costTour, hotel, additionalInf);
        req.getRequestDispatcher(USER_PAGE).forward(req, resp);
    }

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        Tour tour = new Tour();
        tourService = new TourServiceImpl(new TourRepositoryImpl());
        config.getServletContext().setAttribute("tourService", tourService);
    }
}
