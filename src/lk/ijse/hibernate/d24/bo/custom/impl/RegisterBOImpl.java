package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.RegisterBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.RegisterDAO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;

import java.io.IOException;

/**
 * @author : Chavindu
 * created : 4/7/2023-6:12 PM
 **/
public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    @Override
    public boolean saveRegister(RegisterStudent dto) {
        return registerDAO.save(new RegisterStudent(dto.getRes_id(), dto.getDate(), dto.getStudent(), dto.getRoom(), dto.getStatus()));
    }

    @Override
    public boolean deleteRegister(String id) {
        return registerDAO.delete(id);
    }

    @Override
    public boolean updateRegister(RegisterStudent dto) {
        return registerDAO.update(new RegisterStudent(dto.getRes_id(), dto.getDate(), dto.getStudent(), dto.getRoom(), dto.getStatus()));
    }

    @Override
    public RegisterStudent getRegister(String id) throws IOException {
        return registerDAO.getRegister(id);
    }
}
