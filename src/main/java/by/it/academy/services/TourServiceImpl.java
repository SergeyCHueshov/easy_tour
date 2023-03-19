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
    public void createTour(Tour tour) {
        tourRepository.createTour(tour);
    }

    @SneakyThrows
    @Override
    public Tour readTour(long id) {
        return tourRepository.readTour(id);
    }

    @SneakyThrows
    @Override
    public List<Tour> readAllTour() {
        return tourRepository.readAllTour();
    }

    @SneakyThrows
    @Override
    public void updateTour(Long id, String newNameTour, String newStateTour, int newCostTour, String newHotel) {
        tourRepository.updateTour(id, newNameTour, newStateTour, newCostTour, newHotel);
    }

    @SneakyThrows
    @Override
    public void deleteTour(long id) {
        tourRepository.deleteTour(id);
    }
}
