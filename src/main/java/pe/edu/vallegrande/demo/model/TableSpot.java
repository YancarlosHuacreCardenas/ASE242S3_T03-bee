package pe.edu.vallegrande.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "table_spot")
public class TableSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "table_number", nullable = false, unique = true)
    private Integer tableNumber;

    @Column(nullable = false, length = 50)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Lob
    private String notes;

    @Column(length = 50)
    private String status = "Disponible";

    @Column(name = "last_clean")
    private LocalDate lastClean;

    @Column(name = "cleaning_time")
    private LocalTime cleaningTime;

    @Lob
    @Column(name = "layout_details")
    private String layoutDetails;
}
