package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.ReservationDAO;
import lk.ijse.hibernate.d24.entity.Reservation;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/4/2023-4:06 PM
 **/
public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) {
        return false;
    }

    @Override
    public boolean update(Reservation entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ArrayList<Reservation> getAll() {
        return null;
    }
}
