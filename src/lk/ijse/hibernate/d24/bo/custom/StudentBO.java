package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:48 AM
 **/
public interface StudentBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudent();

    boolean saveStudent(Student dto);

    boolean updateStudent(Student dto);

    boolean deleteStudent(String id);

    public Student getStudent(String id) throws IOException;

}
