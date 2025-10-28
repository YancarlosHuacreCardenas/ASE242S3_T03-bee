package pe.edu.vallegrande.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.demo.model.Reservation;
import pe.edu.vallegrande.demo.repository.ReservationRepository;
import pe.edu.vallegrande.demo.service.ReservationService;

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
    public Reservation getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reservation create(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public Reservation update(Integer id, Reservation reservation) {
        if (!repository.existsById(id)) return null;
        reservation.setReservationId(id);
        return repository.save(reservation);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
