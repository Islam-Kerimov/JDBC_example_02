package com.jdbc.starter.entity;

import java.math.BigDecimal;

public class Ticket {

    private Long id;
    private String passengerNO;
    private String getPassengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;

    public Ticket(Long id, String passengerNO, String getPassengerName,
                  Long flightId, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passengerNO = passengerNO;
        this.getPassengerName = getPassengerName;
        this.flightId = flightId;
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

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
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
                ", flightId=" + flightId +
                ", seatNo='" + seatNo + '\'' +
                ", cost=" + cost +
                '}';
    }
}
