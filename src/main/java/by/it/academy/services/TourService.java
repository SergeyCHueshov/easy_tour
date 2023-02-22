package by.it.academy.services;

import by.it.academy.entities.Tour;

import java.util.List;

public interface TourService {
    void createTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf);

    List<Tour> readTour();

    void updateTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf);

    void deleteTour();
}
