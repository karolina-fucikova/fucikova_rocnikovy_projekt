package cz.upce.waterjoy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String jmeno;
    private String ulice;
    private String mesto;
    private String psc;
    private String email;
    private String telefon;
    private String birthDate; // datum narození hlavního objednatele
    private int passengerCount;
    private List<PassengerDTO> passengers; // seznam PassengerDTO
    private String city;
    private String note;
}
