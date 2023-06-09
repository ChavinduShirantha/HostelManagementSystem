package lk.ijse.hibernate.d24.dao.custom;

import lk.ijse.hibernate.d24.dao.CrudDAO;
import lk.ijse.hibernate.d24.entity.Room;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:34 AM
 **/
public interface RoomDAO extends CrudDAO<Room, String> {
    Room getRoom(String id) throws IOException;
}
