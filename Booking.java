package com.srccodes.example;

import java.time.LocalDate;
import java.time.LocalTime;

import com.srccodes.example.Event.EventType;

public class Booking {
    private Event event;
    private int bookTickets;

   
    public Booking() {
    }

    
    public Booking(Event event) {
        this.event = event;
    }

   
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getBookingTickets() {
        return bookTickets;
    }

    public void setBookingTickets(int bookingTickets) {
        this.bookTickets = bookingTickets;
    }

    public void calculateBookingCost(int numTickets) {
        double totalCost = event.calculateTotalRevenue(numTickets);
        System.out.println("Total Booking Cost for " + numTickets + " tickets: " + totalCost);
    }

    public void bookTickets(int numTickets) {
        event.bookTickets(numTickets);
        bookTickets += numTickets;
    }

    public void cancelBooking(int numTickets) { 
        event.cancelBooking(numTickets);
        bookTickets -= numTickets;
    }

    public int getAvailableNoOfTickets() {
        return event.getAvailableSeats();
    }

    public void getEventDetails() { 
        System.out.println("Booking Details:"); 
        System.out.println(event.toString());
    }

    public static void main(String[] args) {
        Event e1 = new Event("Concert",  LocalDate.of(2023, 12, 15),
                LocalTime.of(19, 30), "Concert Hall", 200, 150.0, EventType.CONCERT);

        Booking b = new Booking(e1); 

        b.getEventDetails();

        b.bookTickets(10);
        b.getEventDetails();
        b.calculateBookingCost(b.getBookingTickets());

        b.cancelBooking(5);
          b.getEventDetails();
        b.calculateBookingCost(b.getBookingTickets()); 

        System.out.println("Available Tickets: " + b.getAvailableNoOfTickets());
    }
}