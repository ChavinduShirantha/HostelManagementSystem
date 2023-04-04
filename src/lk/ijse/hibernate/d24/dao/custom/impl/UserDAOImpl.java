package lk.ijse.hibernate.d24.dao.custom.impl;

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hibernate.d24.dao.custom.UserDAO;
import lk.ijse.hibernate.d24.entity.User;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/1/2023-6:02 PM
 **/
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.update(entity);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(ID id) {
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Query q1 = session.createQuery("FROM User");
        ArrayList<User> list = (ArrayList<User>) q1.list();

        t1.commit();
        session.close();
        return list;
    }
}
