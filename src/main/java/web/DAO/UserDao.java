package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> inf();

    void delit(Long id);

    public User get(Long id);

    public void update(User user, Long id);
}
