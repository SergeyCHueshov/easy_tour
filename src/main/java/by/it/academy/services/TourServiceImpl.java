package by.it.academy.services;

import by.it.academy.entities.Tour;
import by.it.academy.repositories.TourRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@RequiredArgsConstructor
public class TourServiceImpl implements TourService{
    private final TourRepository tourRepository;

    @SneakyThrows
    @Override
    public void createTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf) {
        tourRepository.createTour(nameTour, stateTour, costTour, hotel, additionalInf);
    }

    @SneakyThrows
    @Override
    public List<Tour> readTour() {
        return tourRepository.readTour();
    }

    @SneakyThrows
    @Override
    public void updateTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf) {
        tourRepository.updateTour(nameTour, stateTour, costTour, hotel, additionalInf);
    }

    @SneakyThrows
    @Override
    public void deleteTour() {
        tourRepository.deleteTour();
    }
}
