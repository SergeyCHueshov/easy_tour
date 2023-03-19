package by.it.academy.repositories;

import by.it.academy.entities.Tour;

import java.util.List;

public interface TourRepository {

    void createTour(Tour tour);

    Tour readTour(long id);

    List<Tour> readAllTour();

    void updateTour(Long id, String newNameTour, String newStateTour, int newCostTour, String newHotel);

    void deleteTour(Long id);
}
