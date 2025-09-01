package cz.upce.waterjoy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jmeno;
    private String birthDate;

    // Konstruktor bez parametrů je nutný pro JPA
    public Passenger() {}

    public Passenger(String jmeno, String birthDate) {
        this.jmeno = jmeno;
        this.birthDate = birthDate;
    }

    // Gettery a settery
    public Long getId() { return id; }
    public String getJmeno() { return jmeno; }
    public void setJmeno(String jmeno) { this.jmeno = jmeno; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
}
