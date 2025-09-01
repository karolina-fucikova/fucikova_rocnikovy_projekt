package cz.upce.waterjoy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerEmail;
    private LocalDateTime reservationTime;

    // Volitelně můžeš přidat další pole, např. název výletu jako String:
    private String tripName;
}
