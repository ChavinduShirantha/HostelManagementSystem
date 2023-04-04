package lk.ijse.hibernate.d24.util;

import lk.ijse.hibernate.d24.entity.Reservation;
import lk.ijse.hibernate.d24.entity.Room;
import lk.ijse.hibernate.d24.entity.Student;
import lk.ijse.hibernate.d24.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:22 AM
 **/
public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {

        Configuration config = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(User.class).addAnnotatedClass(Room.class).addAnnotatedClass(Reservation.class);
        sessionFactory = config.buildSessionFactory();
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SessionFactoryConfig getInstance() {
        return factoryConfig == null ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
