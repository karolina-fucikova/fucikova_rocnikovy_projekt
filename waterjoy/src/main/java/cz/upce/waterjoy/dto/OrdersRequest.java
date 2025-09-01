package cz.upce.waterjoy.dto;

import java.util.List;
import cz.upce.waterjoy.model.Passenger;

public class OrdersRequest {
    public String jmeno;
    public String ulice;
    public String mesto;
    public String psc;
    public String email;
    public String telefon;
    public String birthDate;
    public int passengerCount;
    public List<Passenger> passenger;
    public String city;
    public String note;
}
