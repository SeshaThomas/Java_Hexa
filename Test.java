package com.srccodes.example;

import java.time.LocalDate;
import java.time.LocalTime;

import com.srccodes.example.Inheritance.TicketBookingSystem;

public class Test {

	

	    public static void main(String[] args) {
	        // Create Venue
	        Venue venue = new Venue("Example Venue", "123 Main Street");
	        venue.displayVenueDetails();

	        // Create Event
	        LocalDate eventDate = LocalDate.of(2023, 12, 31);
	        LocalTime eventTime = LocalTime.of(18, 30);
	        Event event = new Event("Example Event", eventDate, eventTime, venue.getvenueName(), 100,25, EventType.Concert);
	        event.displayEventDetails();

	        // Create Customer
	        Customer customer = new Customer("John Doe", "john@example.com", "123-456-7890");
	        customer.displayCustomerDetails();

	        // Create Booking
	        Booking booking = new Booking(event, 3);
	        booking.bookTickets();

	        // Display updated event details  
	        event.displayEventDetails();
	        
	            Inheritance i=new Inheritance();
		        TicketBookingSystem ticketBookingSystem = i.new TicketBookingSystem(); 

		        // Create Event
		        Event movieEvent = ticketBookingSystem.createEvent("Movie Night", LocalDate.of(2023, 12, 31), LocalTime.of(18, 30),
		                100, 25, "Movie", "Example Venue");
		        ticketBookingSystem.displayEventDetails(movieEvent);

		        // Book Tickets
		        float totalCost = ticketBookingSystem.bookTickets(movieEvent, 3);
		        System.out.println("Total Cost: " + totalCost);

		        // Display updated event details
		        ticketBookingSystem.displayEventDetails(movieEvent); 
		    }
	    } 
	 

