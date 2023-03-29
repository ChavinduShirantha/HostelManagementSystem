package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:48 AM
 **/
public interface StudentBO extends SuperBO{
    boolean saveStudent(Student dto);
}
