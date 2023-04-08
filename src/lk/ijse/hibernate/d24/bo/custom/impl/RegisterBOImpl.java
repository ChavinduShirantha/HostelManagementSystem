package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.RegisterBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.RegisterDAO;
import lk.ijse.hibernate.d24.dto.RegisterStudentDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.RegisterStudent;
import lk.ijse.hibernate.d24.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ArrayList<RegisterStudentDTO> getAllReg() {
        ArrayList<RegisterStudent> all = registerDAO.getAll();

        ArrayList<RegisterStudentDTO> allReg = new ArrayList<>();

        for (RegisterStudent reg : all) {
            allReg.add(new RegisterStudentDTO(
                    reg.getRes_id(),
                    reg.getDate(),
                    reg.getStudent(),
                    reg.getRoom(),
                    reg.getStatus()
            ));
        }

        return allReg;
    }

    @Override
    public List<RegisterStudentDTO> searchReservedRoomById(String id) throws IOException {
        List<RegisterStudent> reserves = registerDAO.searchReservedRoomById(id);

        List<RegisterStudentDTO> reserveDTOS = new ArrayList<>();

        for (RegisterStudent reserve : reserves) {
            reserveDTOS.add(new RegisterStudentDTO(
                    reserve.getRes_id(),
                    reserve.getDate(),
                    reserve.getStudent(),
                    reserve.getRoom(),
                    reserve.getStatus()
            ));

        }
        return reserveDTOS;
    }
}
