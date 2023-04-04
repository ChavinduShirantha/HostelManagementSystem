package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.UserDTO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.entity.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/1/2023-6:02 PM
 **/
public interface UserBO extends SuperBO {
    boolean saveUser(User dto);

    ArrayList<UserDTO> getAllUser() throws IOException;
    boolean updateUser(User dto);

}
