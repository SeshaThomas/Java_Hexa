package com.srccodes.example;


import java.time.LocalDate;
import java.time.LocalTime;

enum EventType {
    Movie, Sports, Concert
}

class Event {
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String venueName;
    private int totalSeats;
    private int availableSeats;
    private float ticketPrice;
    private EventType eventType;

    // Default Constructor
    public Event() {
        this.eventName = "Default";
        this.eventDate = LocalDate.now();
        this.eventTime = LocalTime.now();
        this.venueName = "Default Venue";
        this.totalSeats = 0;
        this.availableSeats = 0;
        this.ticketPrice = 0;
        this.eventType = EventType.Movie; 

    }

    // Overloaded Constructor
    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
                 int totalSeats,float ticketPrice, EventType eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
    }

    // Getters and Setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }


    // toString method
    @Override
    public String toString() {
        return "Event{" +
                "Event Name='" + eventName + '\'' +
                ", Event Date=" + eventDate +
                ", Event Time=" + eventTime +
                ", Venue Name='" + venueName + '\'' +
                ", Total Seats=" + totalSeats +
                ", Available Seats=" + availableSeats +
                ", Ticket Price=" + ticketPrice +
                ", Event Type=" + eventType +
                '}';
    }

    // Other methods
    public float calculateTotalRevenue() {
        return ticketPrice*(totalSeats - availableSeats);
    }

    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }

    public void bookTickets(int numTickets) {
        if (numTickets <= availableSeats) {
            availableSeats -= numTickets;
        } else {
            System.out.println("Not enough available seats.");
        }
    }

    public void cancelBooking(int numTickets) {
        availableSeats += numTickets;
    }

    public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Time: " + eventTime);
        System.out.println("Venue: " + venueName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Ticket Price: " + ticketPrice);
        System.out.println("Event Type: " + eventType);
    }
}

class Venue {
    private String venueName;
    private String address;

    // Default Constructor
    public Venue() {
    	venueName="default";
		address="default";

    }

    // Overloaded Constructor
    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

    // Getters and Setters
    public String getvenueName() {
		return venueName;
	}
	public void setvenueName(String venueName) {
		this.venueName=venueName;
	}
	public String address() {
		return address;
	}
	public void address(String address) {
		this.address=address;
	}

    // toString method
    @Override
    public String toString() {
        return "Venue{" +
                "Venue Name='" + venueName + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }

    // Other methods
    public void displayVenueDetails() {
        System.out.println("Venue Name: " + venueName);
        System.out.println("Address: " + address);
    }
}

class Customer {
    private String customerName;
    private String email;
    private String phoneNumber;

    // Default Constructor
    public Customer() {
    	customerName="default";
		email="default";
		phoneNumber="0000000000";

    }

    // Overloaded Constructor
    public Customer(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName=customerName;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email=email;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNo(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "Customer Name='" + customerName + '\'' +
                ", Email='" + email + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                '}';
    }

    // Other methods
    public void displayCustomerDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}

class Booking {
    private Event event;
    private int numTickets;
    private float totalCost;

    // Default Constructor
    public Booking() {
    	
    }

    // Overloaded Constructor
    public Booking(Event event, int numTickets) {
        this.event = event;
        this.numTickets = numTickets;
        calculateBookingCost();
    }

    // Getters and Setters
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getnumTickets() {
        return numTickets;
    }

    public void setnumTickets(int numTickets) {
        this.numTickets = numTickets;
    }



    // Other methods
    public void calculateBookingCost() {
        totalCost = (float) (event.getTicketPrice()*numTickets);
    }

    public void bookTickets() {
        if (numTickets <= event.getAvailableSeats()) {
            event.bookTickets(numTickets);
            System.out.println("Booking successful! Total Cost: " + totalCost);
        } else {
            System.out.println("Booking failed! Not enough available seats.");
        }
    }

    public void cancelBooking() {
        event.cancelBooking(numTickets);
        System.out.println("Booking canceled for " + numTickets + " tickets.");
    }

    public int getAvailableNoOfTickets() { 
        return event.getAvailableSeats();
    }

    public Event getEventDetails() {
        return event;
    }
}  