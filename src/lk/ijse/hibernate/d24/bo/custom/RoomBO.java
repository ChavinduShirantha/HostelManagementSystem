package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.Room;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:33 AM
 **/
public interface RoomBO extends SuperBO{
    ArrayList<RoomDTO> getAllRoom();

    boolean saveRoom(Room dto);

    boolean updateRoom(Room dto);

    boolean deleteRoom(String id);

    public Room getRoom(String id) throws IOException;
}
