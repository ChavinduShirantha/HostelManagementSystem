package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public interface RegisterBO extends SuperBO{
    boolean saveRegister(RegisterStudent dto);
    boolean deleteRegister(String id);
    boolean updateRegister(RegisterStudent dto);
    public RegisterStudent getRegister(String id) throws IOException;

}
