package cz.upce.waterjoy.controller;

import cz.upce.waterjoy.service.UserService;
import cz.upce.waterjoy.service.OrderService;
import cz.upce.waterjoy.dto.RegisterRequest;
import cz.upce.waterjoy.model.Orders;
import cz.upce.waterjoy.model.Passenger;
import cz.upce.waterjoy.model.User;
import cz.upce.waterjoy.dto.OrdersRequest;
import cz.upce.waterjoy.dto.OrderDTO;
import cz.upce.waterjoy.dto.PassengerDTO;
import cz.upce.waterjoy.repository.OrderRepository;
import cz.upce.waterjoy.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController //zpracovává HTTP požadavky a vracet odpovědi (např. JSON)
@RequestMapping("/api/auth") // Určuje základní URL cestu
public class AuthController {

    private List<Orders> orders = new ArrayList<>();

    private final OrderRepository orderRepository;

    public AuthController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired // Automaticky vloží instanci třídy UserService
    private UserService userService;


    @PostMapping("/register") // Zpracovává HTTP POST požadavek
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) { // Příjem registračních dat ve formátu JSON a tvorba nového uživatele
        boolean success = userService.register(request.getUsername(), request.getEmail(), request.getPassword()); // Volá metodu register ze služby a vrací true, pokud se registrace povedla
        if (success) {
            return ResponseEntity.ok("Registrace úspěšná!");
        } else {
            return ResponseEntity.badRequest().body("Uživatel s tímto jménem již existuje.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RegisterRequest request) {
        boolean loggedIn = userService.login(request.getUsername(), request.getEmail(), request.getPassword()); // Volá metodu login ze služby a ověřuje přihlašovací údaje
        if (loggedIn) {
            return ResponseEntity.ok("Přihlášení úspěšné");
        } else {
            return ResponseEntity.status(401).body("Špatné přihlašovací údaje");
        }
    }
    @DeleteMapping("/deleteuser/{username}") // Zpracovává HTTP DELETE požadavek na smazání uživatele podle username
    public ResponseEntity<String> deleteUser(@PathVariable String username) { // Získá username z URL jako parametr
        boolean deleted = userService.deleteUserByUsername(username); // Zavolá službu pro smazání uživatele podle jména
        if (deleted) {
            return ResponseEntity.ok("Uživatel byl úspěšně smazán.");
        } else {
            return ResponseEntity.status(404).body("Uživatel nenalezen.");
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        // Převod PassengerDTO na Passenger entity
        List<Passenger> passengers = orderDTO.getPassengers().stream()
                .map(dto -> new Passenger(dto.getName(), dto.getBirthDate()))
                .collect(Collectors.toList());

        // Vytvoření Orders entity bez id (JPA ho vygeneruje)
        Orders newOrders = new Orders(
                orderDTO.getJmeno(),
                orderDTO.getUlice(),
                orderDTO.getMesto(),
                orderDTO.getPsc(),
                orderDTO.getEmail(),
                orderDTO.getTelefon(),
                orderDTO.getBirthDate(),
                orderDTO.getPassengerCount(),
                passengers,
                orderDTO.getCity(),
                orderDTO.getNote()
        );

        orderRepository.save(newOrders); // uloží do DB

        // Vrací jen jednoduchou zprávu
        return ResponseEntity.ok("Vaše objednávka byla úspěšně uložena.");
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        // Kontrola, zda objednávka existuje
        Optional<Orders> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            orderRepository.deleteById(id); // smaže objednávku
            return ResponseEntity.ok("Objednávka byla úspěšně smazána.");
        } else {
            return ResponseEntity.status(404).body("Objednávka nenalezena.");
        }
    }

}
