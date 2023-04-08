package lk.ijse.hibernate.d24.dao.custom.impl;

import lk.ijse.hibernate.d24.dao.custom.StudentDAO;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public boolean update(Student entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.update(entity);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Student stu = session.get(Student.class, s);
        session.delete(stu);

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Student> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        Query q1 = session.createQuery("FROM Student");
        ArrayList<Student> list = (ArrayList<Student>) q1.list();

        t1.commit();
        session.close();
        return list;
    }

    @Override
    public Student getStudent(String id) throws IOException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student st = session.get(Student.class, id);

        transaction.commit();
        session.close();

        return st;
    }
}
