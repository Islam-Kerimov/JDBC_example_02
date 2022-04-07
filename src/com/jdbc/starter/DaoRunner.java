package com.jdbc.starter;

import com.jdbc.starter.dao.TicketDao;
import com.jdbc.starter.entity.Ticket;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DaoRunner {

    public static void main(String[] args) {
//        saveTest();
//        deleteTest();
//        updateTest();
//        selectAllTest();
    }

    private static void selectAllTest() {
        List<Ticket> tickets = TicketDao.getInstance().findAll();
        tickets.forEach(System.out::println);
    }

    private static void updateTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        Optional<Ticket> ticket = ticketDao.findById(2L);
        System.out.println(ticket);

        ticket.ifPresent(ticket1 -> {
            ticket1.setCost(BigDecimal.valueOf(191));
            ticketDao.update(ticket1);
        });

        System.out.println(ticket);
    }

    private static void deleteTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        boolean deleteTicket = ticketDao.delete(57L);
        System.out.println(deleteTicket);
    }

    private static void saveTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = new Ticket();
        ticket.setPassengerNO("12345");
        ticket.setGetPassengerName("Test");
        ticket.setFlightId(3L);
        ticket.setSeatNo("A2");
        ticket.setCost(BigDecimal.TEN);

        Ticket saveTicket = ticketDao.save(ticket);
        System.out.println(saveTicket);
    }

}
