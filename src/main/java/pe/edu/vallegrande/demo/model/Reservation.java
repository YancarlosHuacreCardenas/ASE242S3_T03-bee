package pe.edu.vallegrande.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @ManyToOne
    @JsonIgnoreProperties({"reservations"})
    @JoinColumn(name = "customer_customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({"reservations"})
    @JoinColumn(name = "table_spot_table_id", nullable = false)
    private TableSpot tableSpot;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
