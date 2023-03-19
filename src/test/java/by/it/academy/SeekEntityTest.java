package by.it.academy;

import by.it.academy.entities.User;
import by.it.academy.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertNotNull;

public class SeekEntityTest {
    @Test
    public void seekEntity() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = new User();
        user.setLogin("");
        entityManager.persist(user);
        User detectedUser = entityManager.find(User.class, 1L);
        assertNotNull(detectedUser);
    }
}
