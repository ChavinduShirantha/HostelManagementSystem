package lk.ijse.hibernate.d24.dao;

import lk.ijse.hibernate.d24.dao.custom.impl.StudentDAOImpl;

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
        STUDENT
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
