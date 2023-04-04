package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.ReservationDAO;
import lk.ijse.hibernate.d24.entity.Reservation;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/4/2023-4:06 PM
 **/
public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) {
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

        Reservation reservation = session.get(Reservation.class, s);
        session.delete(reservation);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Reservation> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Query q1 = session.createQuery("FROM Reservation ");
        ArrayList<Reservation> list = (ArrayList<Reservation>) q1.list();

        t1.commit();
        session.close();
        return list;
    }
}
