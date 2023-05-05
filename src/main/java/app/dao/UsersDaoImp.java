package app.dao;

import app.model.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsersDaoImp implements UsersDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Users user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Users user) {
        entityManager.createQuery("DELETE FROM Users u WHERE u.id = :id ").setParameter("id", user.getId()).executeUpdate();
    }

    @Override
    public List<Users> getAllUsers() {
        //TypedQuery <Users> query = (TypedQuery<Users>) entityManager.createQuery("from Users ");
        return entityManager.createQuery("from Users ").getResultList();
    }

    @Override
    public void update(Users user) {
        entityManager.merge(user);
    }
    @Override
    public Users showUser(int id) {
        return entityManager.find(Users.class, id);
    }
}
