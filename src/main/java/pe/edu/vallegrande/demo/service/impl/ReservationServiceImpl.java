package pe.edu.vallegrande.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.Reservation;
import pe.edu.vallegrande.demo.repository.ReservationRepository;
import pe.edu.vallegrande.demo.service.ReservationService;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public List<Reservation> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> getActive() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public List<Reservation> getInactive() {
        return repository.findByIsActiveFalse();
    }

    @Override
    public Reservation getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reservation create(Reservation reservation) {
        reservation.setIsActive(true);
        return repository.save(reservation);
    }

    @Override
    public Reservation update(Integer id, Reservation reservation) {
        Reservation existing = getById(id);
        if (existing != null) {
            existing.setReservationDate(reservation.getReservationDate());
            existing.setReservationTime(reservation.getReservationTime());
            existing.setGuestsCount(reservation.getGuestsCount());
            existing.setStatus(reservation.getStatus());
            existing.setCustomer(reservation.getCustomer());
            existing.setTableSpot(reservation.getTableSpot());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Reservation reservation = getById(id);
        if (reservation != null) {
            reservation.setIsActive(false);
            repository.save(reservation);
        }
    }

    @Override
    public void restore(Integer id) {
        Reservation reservation = getById(id);
        if (reservation != null) {
            reservation.setIsActive(true);
            repository.save(reservation);
        }
    }
}
