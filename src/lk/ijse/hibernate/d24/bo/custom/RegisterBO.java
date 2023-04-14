package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.RegisterStudentDTO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public interface RegisterBO extends SuperBO {
    boolean saveRegister(RegisterStudent dto);

    boolean deleteRegister(String id);

    boolean updateRegister(RegisterStudent dto);

    RegisterStudent getRegister(String id) throws IOException;

    ArrayList<RegisterStudentDTO> getAllReg();

    List<RegisterStudentDTO> searchReservedRoomById(String id) throws IOException;

}
