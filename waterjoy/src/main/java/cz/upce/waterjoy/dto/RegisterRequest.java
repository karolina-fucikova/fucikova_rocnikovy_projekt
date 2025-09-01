package cz.upce.waterjoy.dto;

public class RegisterRequest { // Deklaruje veřejnou třídu RegisterRequest – slouží k přenosu dat při registraci (z klienta na server)
    private String username;
    private String email;
    private String password;

    public String getUsername() { // Získá hodnotu proměnné
        return username;
    }
    public void setUsername(String username) { // Nastaví hodnotu proměnné
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
