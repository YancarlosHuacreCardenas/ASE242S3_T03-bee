package pe.edu.vallegrande.demo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.demo.model.Reservation;
import pe.edu.vallegrande.demo.service.ReservationService;

import java.util.List;
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor

public class ReservationRest {

    private final ReservationService service;

    @GetMapping
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/activos")
    public List<Reservation> getActive() {
        return service.getActive();
    }

    @GetMapping("/inactivos")
    public List<Reservation> getInactive() {
        return service.getInactive();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return service.create(reservation);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation reservation) {
        return service.update(id, reservation);
    }

    @PatchMapping("/{id}/eliminar")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PatchMapping("/{id}/restaurar")
    public void restore(@PathVariable Integer id) {
        service.restore(id);
    }
}
