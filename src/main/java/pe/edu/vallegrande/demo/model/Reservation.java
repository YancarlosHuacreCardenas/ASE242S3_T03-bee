package pe.edu.vallegrande.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "reservation_time", nullable = false)
    private LocalTime reservationTime;

    @Column(name = "guests_count", nullable = false)
    private Integer guestsCount;

    @Column(length = 50)
    private String status = "Pendiente";

    // 🔹 Relaciones (FK)
    @ManyToOne
    @JoinColumn(name = "customer_customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "table_spot_table_id", nullable = false)
    private TableSpot tableSpot;
}
