package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.RegisterDAO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean save(RegisterStudent entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(RegisterStudent entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.update(entity);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        RegisterStudent stu = session.get(RegisterStudent.class, s);
        session.delete(stu);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<RegisterStudent> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Query q1 = session.createQuery("FROM RegisterStudent ");
        ArrayList<RegisterStudent> list = (ArrayList<RegisterStudent>) q1.list();

        t1.commit();
        session.close();
        return list;
    }

    @Override
    public RegisterStudent getRegister(String id) throws IOException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        RegisterStudent st = session.get(RegisterStudent.class, id);

        transaction.commit();
        session.close();

        return st;
    }

    @Override
    public List<RegisterStudent> searchReservedRoomById(String id) throws IOException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM RegisterStudent WHERE room = :room_type_id";
        Query query = session.createQuery(hql);

        Room room = new Room();
        room.setR_id(id);

        query.setParameter("room_type_id", room);
        List<RegisterStudent> r = query.list();

        transaction.commit();
        session.close();

        return r;
    }
}
