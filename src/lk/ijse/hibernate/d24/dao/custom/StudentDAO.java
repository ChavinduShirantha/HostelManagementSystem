package lk.ijse.hibernate.d24.dao.custom;

import lk.ijse.hibernate.d24.dao.CrudDAO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:50 AM
 **/
public interface StudentDAO extends CrudDAO<Student,String> {

}
