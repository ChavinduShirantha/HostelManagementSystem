package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.StudentDAO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;

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
}
