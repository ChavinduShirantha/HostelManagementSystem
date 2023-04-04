package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.entity.Reservation;

import java.util.ArrayList;

/**
 * @author : Chavindu
 * created : 4/4/2023-4:06 PM
 **/
public interface ReservationBO extends SuperBO{
    ArrayList<ReservationDTO> getAllReservation();

    boolean saveReservation(Reservation dto);

    boolean updateReservation(Reservation dto);

    boolean deleteReservation(String id);
}
