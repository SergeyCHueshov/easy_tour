package by.it.academy.repositories;

import by.it.academy.entities.Tour;
import by.it.academy.utils.JPAUtil;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TourRepositoryImpl implements TourRepository {
    private EntityManager entityManager;

    @SneakyThrows
    @Override
    public void createTour(Tour tour) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(tour);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SneakyThrows
    @Override
    public Tour readTour(long id) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager.find(Tour.class, id);
    }

    @SneakyThrows
    @Override
    public List<Tour> readAllTour() {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Tour> namedQuery = entityManager.createNamedQuery("Tour.getAll", Tour.class);
        entityManager.getTransaction().commit();
        entityManager.close();
        return namedQuery.getResultList();
    }

    @SneakyThrows
    @Override
    public void updateTour(Long id, String newNameTour, String newStateTour, int newCostTour, String newHotel) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Tour tour = entityManager.find(Tour.class, id);
        tour.setNameTour(newNameTour);
        tour.setStateTour(newStateTour);
        tour.setCostTour(newCostTour);
        tour.setHotel(newHotel);
        entityManager.merge(tour);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SneakyThrows
    @Override
    public void deleteTour(Long id) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Tour tour = entityManager.find(Tour.class, id);
        entityManager.remove(tour);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

