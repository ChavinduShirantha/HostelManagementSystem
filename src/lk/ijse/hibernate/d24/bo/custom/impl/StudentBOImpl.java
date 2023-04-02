package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.StudentDAO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:48 AM
 **/
public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(Student dto) {
        return studentDAO.save(new Student(dto.getStd_id(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getDate(), dto.getGender()));
    }

    @Override
    public boolean updateStudent(Student dto) {
        return studentDAO.update(new Student(dto.getStd_id(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getDate(), dto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }


    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        ArrayList<Student> all = studentDAO.getAll();

        ArrayList<StudentDTO> allStudent = new ArrayList<>();

        for (Student student : all) {
            allStudent.add(new StudentDTO(
                    student.getStd_id(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDate(),
                    student.getGender()
            ));
        }

        return allStudent;
    }
}
