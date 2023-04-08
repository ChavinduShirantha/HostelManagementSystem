package lk.ijse.hibernate.d24.bo;

import lk.ijse.hibernate.d24.bo.custom.SuperBO;
import lk.ijse.hibernate.d24.bo.custom.impl.*;

/**
 * @author : Chavindu
 * created : 3/29/2023-9:16 AM
 **/
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        STUDENT,USER,ROOM,REGISTER
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case USER:
                return new UserBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }
}
