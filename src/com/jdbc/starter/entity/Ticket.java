package com.jdbc.starter.entity;

import java.math.BigDecimal;

public class Ticket {

    private Long id;
    private String passengerNO;
    private String getPassengerName;
    private Flight flight;
    private String seatNo;
    private BigDecimal cost;

    public Ticket(Long id, String passengerNO, String getPassengerName,
                  Flight flight, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passengerNO = passengerNO;
        this.getPassengerName = getPassengerName;
        this.flight = flight;
        this.seatNo = seatNo;
        this.cost = cost;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNO() {
        return passengerNO;
    }

    public void setPassengerNO(String passengerNO) {
        this.passengerNO = passengerNO;
    }

    public String getGetPassengerName() {
        return getPassengerName;
    }

    public void setGetPassengerName(String getPassengerName) {
        this.getPassengerName = getPassengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passengerNO='" + passengerNO + '\'' +
                ", getPassengerName='" + getPassengerName + '\'' +
                ", flight=" + flight +
                ", seatNo='" + seatNo + '\'' +
                ", cost=" + cost +
                '}';
    }
}
