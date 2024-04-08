package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> inf() {

        return entityManager.createQuery("select e from User e", User.class).getResultList();

    }

    @Override
    public void delit(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User get(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user, Long id) {

        entityManager.detach(entityManager.find(User.class, id));
        entityManager.merge(user);
    }


}
