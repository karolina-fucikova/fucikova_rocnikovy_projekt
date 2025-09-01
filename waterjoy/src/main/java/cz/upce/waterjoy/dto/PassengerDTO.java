package cz.upce.waterjoy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
    private String name;
    private String birthDate; // pokud chceš, může být LocalDate, ale String je jednodušší pro JSON
}
