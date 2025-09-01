package cz.upce.waterjoy.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jmeno;
    private String ulice;
    private String mesto;
    private String psc;
    private String email;
    private String telefon;
    private String birthDate;
    private int passengerCount;
    private String city;
    private String note;
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    // Konstruktor bez id – JPA si ho nastaví sama
    public Orders(String jmeno, String ulice, String mesto, String psc,
                  String email, String telefon, String birthDate, int passengerCount,
                  List<Passenger> passengers, String city, String note) {
        this.jmeno = jmeno;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.birthDate = birthDate;
        this.passengerCount = passengerCount;
        this.passengers = passengers;
        this.city = city;
        this.note = note;
        this.createdAt = LocalDateTime.now();
    }

    // JPA vyžaduje prázdný konstruktor
    public Orders() {}
}
