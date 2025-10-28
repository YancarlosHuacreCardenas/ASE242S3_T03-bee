package pe.edu.vallegrande.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.demo.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
