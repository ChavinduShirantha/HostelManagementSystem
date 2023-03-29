package lk.ijse.hibernate.d24.util;

import lk.ijse.hibernate.d24.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:22 AM
 **/
public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfig()
                : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
