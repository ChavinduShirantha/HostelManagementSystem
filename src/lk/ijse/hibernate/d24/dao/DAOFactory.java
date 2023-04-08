package lk.ijse.hibernate.d24.dao;

import lk.ijse.hibernate.d24.dao.custom.impl.*;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:17 AM
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT, USER, ROOM,REGISTER
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            default:
                return null;
        }
    }
}
