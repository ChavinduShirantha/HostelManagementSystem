package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.UserBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.UserDAO;
import lk.ijse.hibernate.d24.dto.UserDTO;
import lk.ijse.hibernate.d24.entity.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/1/2023-6:02 PM
 **/
public class UserBOImpl implements UserBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(User dto) {
        return userDAO.save(new User(dto.getUser_name(), dto.getPwd(), dto.getName(), dto.getSurName(), dto.getCity(), dto.getContact(), dto.getEmail()));
    }

    @Override
    public ArrayList<UserDTO> getAllUser() throws IOException {
        ArrayList<User> all = userDAO.getAll();

        ArrayList<UserDTO> userLogin = new ArrayList<>();


        for (User user : all) {
            userLogin.add(new UserDTO(
                    user.getUser_name(),
                    user.getPwd(),
                    user.getName(),
                    user.getSurName(),
                    user.getCity(),
                    user.getContact(),
                    user.getEmail()
            ));
        }

        return userLogin;
    }

    @Override
    public boolean updateUser(User dto) {
        return userDAO.update(new User(dto.getUser_name(), dto.getPwd()));
    }
}
