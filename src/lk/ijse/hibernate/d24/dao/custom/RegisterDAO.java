package lk.ijse.hibernate.d24.dao.custom;

import lk.ijse.hibernate.d24.dao.CrudDAO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public interface RegisterDAO extends CrudDAO<RegisterStudent,String> {
    public RegisterStudent getRegister(String id) throws IOException;
}