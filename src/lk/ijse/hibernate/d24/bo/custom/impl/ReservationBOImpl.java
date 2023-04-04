package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dao.DAOFactory;
import lk.ijse.hibernate.d24.dao.custom.ReservationDAO;
import lk.ijse.hibernate.d24.dao.custom.StudentDAO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.Reservation;
import lk.ijse.hibernate.d24.entity.Student;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/4/2023-4:06 PM
 **/
public class ReservationBOImpl implements ReservationBO {
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    @Override
    public ArrayList<ReservationDTO> getAllReservation() {
        ArrayList<Reservation> all = reservationDAO.getAll();

        ArrayList<ReservationDTO> allReservation = new ArrayList<>();

        for (Reservation reservation : all) {
            allReservation.add(new ReservationDTO(
                    reservation.getRes_id(),
                    reservation.getDate(),
                    reservation.getStudent_id(),
                    reservation.getRoom_type_id(),
                    reservation.getStatus()
            ));
        }

        return allReservation;
    }

    @Override
    public boolean saveReservation(Reservation dto) {
        return reservationDAO.save(new Reservation(dto.getRes_id(), dto.getDate(), dto.getStudent_id(), dto.getRoom_type_id(), dto.getStatus()));
    }

    @Override
    public boolean updateReservation(Reservation dto) {
        return reservationDAO.update(new Reservation(dto.getRes_id(), dto.getDate(), dto.getStudent_id(), dto.getRoom_type_id(), dto.getStatus()));
    }

    @Override
    public boolean deleteReservation(String id) {
        return reservationDAO.delete(id);
    }
}
