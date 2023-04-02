package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.RoomDAO;
import lk.ijse.hibernate.d24.entity.Room;

import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:34 AM
 **/
public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.update(entity);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String r) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Room room = session.get(Room.class, r);
        session.delete(room);

        t1.commit();
        session.close();
        return true;    }

    @Override
    public ArrayList<Room> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Query q1 = session.createQuery("FROM Room");
        ArrayList<Room> list = (ArrayList<Room>) q1.list();

        t1.commit();
        session.close();
        return list;
    }
}
