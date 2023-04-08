package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.RoomDAO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.Room;


import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/2/2023-9:33 AM
 **/
public class RoomBOImpl implements RoomBO {
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        ArrayList<Room> all = roomDAO.getAll();

        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room : all) {
            allRoom.add(new RoomDTO(
                    room.getR_id(),
                    room.getR_type(),
                    room.getKey_money(),
                    room.getQty()
            ));
        }

        return allRoom;
    }

    @Override
    public boolean saveRoom(Room dto) {
        return roomDAO.save(new Room(dto.getR_id(), dto.getR_type(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean updateRoom(Room dto) {
        return roomDAO.update(new Room(dto.getR_id(), dto.getR_type(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }

    @Override
    public Room getRoom(String id) throws IOException {
        return roomDAO.getRoom(id);
    }
}
