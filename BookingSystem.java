package com.srccodes.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class BookingSystem {

    private Map<String, Event> events;

    public BookingSystem() {
        this.events = new HashMap<>();
    }

    public abstract Event createEvent(String eventName, String date, String time, int totalSeats,
                                      double ticketPrice, String eventType, String venueName);

    public void displayEventDetails(Event event) {
        if (event != null) {
            event.displayEventDetails();
        } else {
            System.out.println("Event not found.");
        }
    }

    public double bookTickets(Event event, int numTickets) {
        if (event != null && event.getAvailableSeats() >= numTickets) {
            double totalCost = event.bookTickets(numTickets);
            System.out.println(numTickets + " tickets booked successfully. Total Cost: $" + totalCost);
            return totalCost;
        } else {
            System.out.println("Booking failed. Not enough available seats.");
            return 0.0;
        }
    }

    public void cancelTickets(Event event, int numTickets) {
        if (event != null) {
            event.cancelBooking(numTickets);
            System.out.println(numTickets + " tickets canceled successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public Map<String, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Event> events) {
        this.events = events;
    }

    public abstract void main();
}
 class TicketBookingSystem extends BookingSystem {

    public static void main(String[] args) {
        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();
        ticketBookingSystem.main();
    }

    @Override
    public Event createEvent(String eventName, String date, String time, int totalSeats,
                             double ticketPrice, String eventType, String venueName) {
        Event event = null;

        switch (eventType.toUpperCase()) {
            case "MOVIE":
                event = new Event.Movie(eventName, date, time, totalSeats, ticketPrice, eventType, venueName);
                break;
            case "SPORTS":
                event = new Event.Sports(eventName, date, time, totalSeats, ticketPrice, eventType, venueName);
                break;
            case "CONCERT":
                event = new Event.Concert(eventName, date, time, totalSeats, ticketPrice, eventType, venueName);
                break;
            default:
                System.out.println("Invalid event type.");
        }

        if (event != null) {
            getEvents().put(eventName, event);
            System.out.println("Event created successfully.");
        }

        return event;
    }

    @Override
    public void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command: (create_event, book_tickets, cancel_tickets, get_available_seats, exit)");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "create_event":
                    createEventFromUserInput(scanner);
                    break;
                case "book_tickets":
                    bookTicketsFromUserInput(scanner);
                    break;
                case "cancel_tickets":
                    cancelTicketsFromUserInput(scanner);
                    break;
                case "get_available_seats":
                    displayAvailableSeats();
                    break;
                case "exit":
                    System.out.println("Exiting the ticket booking system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private void createEventFromUserInput(Scanner scanner) {
        System.out.println("Enter event details:");
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        System.out.print("Time: ");
        String time = scanner.nextLine();
        System.out.print("Total Seats: ");
        int totalSeats = scanner.nextInt();
        System.out.print("Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Event Type (Movie, Sports, Concert): ");
        String eventType = scanner.nextLine();
        System.out.print("Venue Name: ");
        String venueName = scanner.nextLine();

        createEvent(eventName, date, time, totalSeats, ticketPrice, eventType, venueName);
    }

    private void bookTicketsFromUserInput(Scanner scanner) {
        System.out.print("Enter Event Name: ");
        String eventName = scanner.nextLine();
        Event event = getEvents().get(eventName);

        if (event != null) {
            System.out.print("Enter Number of Tickets to Book: ");
            int numTickets = scanner.nextInt();
            bookTickets(event, numTickets);
        } else {
            System.out.println("Event not found.");
        }
    }

    private void cancelTicketsFromUserInput(Scanner scanner) {
        System.out.print("Enter Event Name: ");
        String eventName = scanner.nextLine();
        Event event = getEvents().get(eventName);

        if (event != null) {
            System.out.print("Enter Number of Tickets to Cancel: ");
            int numTickets = scanner.nextInt();
            cancelTickets(event, numTickets);
        } else {
            System.out.println("Event not found.");
        }
    }

    private void displayAvailableSeats() {
        System.out.println("Available Seats for Each Event:");
        for (Event event : getEvents().values()) {
            System.out.println(event.getEventName() + ": " + event.getAvailableSeats() + " seats");
        }
    }
}
