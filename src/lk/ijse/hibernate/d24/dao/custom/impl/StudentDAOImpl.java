package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.StudentDAO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 3/29/2023-10:50 AM
 **/
public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

}
