package cz.upce.waterjoy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Říká, že ID se bude generovat automaticky pomocí AUTO_INCREMENT
    private Long id; // Primární klíč

    @Column(unique = true) // Říká, že hodnota "username" musí být v databázi jedinečná
    private String username;
    private String email;
    private String password;
    private boolean enabled; // Označuje, zda je účet aktivní/povolený

    public Long getId() { return id; } // Vrací hodnotu ID
    public void setId(Long id) { this.id = id; } // Nastavuje hodnotu ID

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


}
