package lk.ijse.hibernate.d24.dao.custom;

import lk.ijse.hibernate.d24.dao.CrudDAO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;

import java.io.IOException;
import java.util.List;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public interface RegisterDAO extends CrudDAO<RegisterStudent, String> {
    RegisterStudent getRegister(String id) throws IOException;

    List<RegisterStudent> searchReservedRoomById(String id) throws IOException;
}
