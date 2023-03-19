package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.utils.JPAUtil;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager;

    @SneakyThrows
    @Override
    public void createUser(User user) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SneakyThrows
    @Override
    public void authorizeUser(User user) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SneakyThrows
    @Override
    public User readUser(long id) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager.find(User.class, id);
    }

    @SneakyThrows
    @Override
    public List<User> readAllUsers() {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("User.getAll", User.class);
        entityManager.getTransaction().commit();
        entityManager.close();
        return namedQuery.getResultList();
    }

    @SneakyThrows
    @Override
    public void updateUser(Long id, String newPassword, String newLogin) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SneakyThrows
    @Override
    public void deleteUser(Long id) {
        entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
