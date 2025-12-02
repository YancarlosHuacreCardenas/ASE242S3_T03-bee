package pe.edu.vallegrande.demo.service;

import pe.edu.vallegrande.demo.model.Reservation;
import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    List<Reservation> getActive();
    List<Reservation> getInactive();
    Reservation getById(Integer id);
    Reservation create(Reservation reservation);
    Reservation update(Integer id, Reservation reservation);
    void delete(Integer id); // lógica
    void restore(Integer id);
}
