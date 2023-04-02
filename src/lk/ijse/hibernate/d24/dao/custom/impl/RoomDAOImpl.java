package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.RoomDAO;
import lk.ijse.hibernate.d24.entity.Room;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:34 AM
 **/
public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) {
        return false;
    }

    @Override
    public boolean update(Room entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ArrayList<Room> getAll() {
        return null;
    }
}
