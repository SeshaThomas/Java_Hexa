package com.srccodes.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.srccodes.example.Inheritance.ConcertType;
import com.srccodes.example.Inheritance.Genre;



public class Abstraction {
	enum EventType {
	    Movie, Concert, Sports
	}

	// Abstract Event class
	abstract class Event {
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
	                 int totalSeats, float ticketPrice, EventType eventType) {
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

	// Concrete Movie class
	enum Genre {
	    Action, Comedy, Horror
	} 
	class Movie extends Event {
	    private Genre genre;
	    private String actorName;
	    private String actressName;

public Movie(String eventName, LocalDate date, LocalTime time, String venueName, int totalSeats, float ticketPrice, String string, String string2, String string3) {
	    	
	        super();
	    }

	    // Overloaded Constructor
	    public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
	                 int totalSeats,float ticketPrice, Genre genre, String actorName, String actressName) {
	        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, EventType.Movie);
	        this.genre = genre;
	        this.actorName = actorName;
	        this.actressName = actressName;
	    }

	    // Getters and Setters
	    public Genre getGenre() {
	        return genre;
	    }

	    public void setGenre(Genre genre) {
	        this.genre = genre;
	    }

	    public String getActorName() {
	        return actorName;
	    }

	    public void setActorName(String actorName) {
	        this.actorName = actorName;
	    }

	    public String getActressName() {
	        return actressName;
	    }

	    public void setActressName(String actressName) {
	        this.actressName = actressName;
	    }



	    @Override
	    public void displayEventDetails() {
	        super.displayEventDetails();
	        System.out.println("Genre: " + genre);
	        System.out.println("Actor: " + actorName);
	        System.out.println("Actress: " + actressName);
	    }
	}

	// Concrete Concert class
	class Concert extends Event {
	    private String artist;
	    private ConcertType type;

	    public Concert() {
	        super();
	    }

	    // Overloaded Constructor
	    public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
	                   int totalSeats, float ticketPrice, String artist, ConcertType type) {
	        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, EventType.Concert);
	        this.artist = artist;
	        this.type = type;
	    }

	    public Concert(String eventName, LocalDate date, LocalTime time, String venueName, int totalSeats,
				float ticketPrice, String string, String string2) {
			// TODO Auto-generated constructor stub
		}

		// Getters and Setters
	    public String getArtist() {
	        return artist;
	    }

	    public void setArtist(String artist) {
	        this.artist = artist;
	    }

	    public ConcertType getType() {
	        return type;
	    }

	    public void setType(ConcertType type) {
	        this.type = type;
	    }



	    public void displayConcertDetails() {
	        super.displayEventDetails();
	        System.out.println("Artist: " + artist);
	        System.out.println("Type: " + type);
	    }
	}

	// Concrete Sports class
	class Sports extends Event {
	    private String sportName;
	    private String teamsName;
	    public Sports() {
	        super();
	    }

	    // Overloaded Constructor
	    public Sports(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
	                  int totalSeats, float ticketPrice, String sportName, String teamsName) {
	        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, EventType.Sports);
	        this.sportName = sportName;
	        this.teamsName = teamsName;
	    }

	    // Getters and Setters
	    public String getSportName() {
	        return sportName;
	    }

	    public void setSportName(String sportName) {
	        this.sportName = sportName;
	    }

	    public String getTeamsName() {
	        return teamsName;
	    }

	    public void setTeamsName(String teamsName) {
	        this.teamsName = teamsName;
	    }



	    public void displaySportDetails() {
	        super.displayEventDetails();
	        System.out.println("Sport: " + sportName);
	        System.out.println("Teams: " + teamsName);
	    }
	}


	// Abstract BookingSystem class
	abstract class BookingSystem {
	    protected Map<String, Event> events;

	    public BookingSystem() {
	        this.events = new HashMap<>();
	    }

	    public abstract Event createEvent(String eventName, LocalDate date, LocalTime time, int totalSeats,
	                                       float ticketPrice, String eventType, String venueName);

	    public abstract void bookTickets(Event event, int numTickets);

	    public abstract void cancelTickets(Event event, int numTickets);

	    public abstract int getAvailableSeats(Event event);
	}

	abstract // Concrete TicketBookingSystem class
	class TicketBookingSystem extends BookingSystem {

	    @Override 
	    public Event createEvent(String eventName, LocalDate date, LocalTime time, int totalSeats,
	                              float ticketPrice, String eventType, String venueName) {
	        EventType type = EventType.valueOf(eventType);
	        Event event;
	        switch (type) {
	            case Movie:
	                event = new Movie(eventName, date, time, venueName, totalSeats, ticketPrice,"Action", "John Doe", "Jane Doe");
	                break;
	            case Concert:
	                event = new Concert(eventName, date, time, venueName, totalSeats, ticketPrice, "Artist Name", "Rock");
	                break;
	            case Sports:
	                event = new Sports(eventName, date, time, venueName, totalSeats, ticketPrice, "Football", "India vs Pakistan");
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid event type");
	        }
	        events.put(eventName, event);
	        return event;
	    }

	    @Override
	    public void bookTickets(Event event, int numTickets) {
	        if (event != null) {
	            event.bookTickets(numTickets);
	        } else {
	            System.out.println("Event not found.");
	        }
	    }

	    @Override
	    public void cancelTickets(Event event, int numTickets) {
	        if (event != null) {
	            event.cancelBooking(numTickets);
	        } else {
	            System.out.println("Event not found.");
	        }
	    }

	    @Override
	    public int getAvailableSeats(Event event) {
	        if (event != null) {
	            return event.getAvailableSeats();
	        } else {
	            System.out.println("Event not found.");
	            return -1;
	        }
	    }
	    public class ConcreteTicketBookingSystem extends TicketBookingSystem {
	    }

	    public static void main(String[] args) {
	    	Abstraction a=new Abstraction(); 
	    	ConcreteTicketBookingSystem ticketBookingSystem = a.new ConcreteTicketBookingSystem();

	        Scanner scanner = new Scanner(System.in);

	        while (true) { 
	            System.out.println("Enter a command ('create_event', 'book_tickets', 'cancel_tickets', 'get_available_seats', 'exit'):");
	            String command = scanner.nextLine();

	            switch (command) { 
	                case "createEvent":
	                    System.out.println("Enter event details:");
	                    System.out.print("Event Name: ");
	                    String eventName = scanner.nextLine();
	                    System.out.print("Date (YYYY-MM-DD): ");
	                    LocalDate date = LocalDate.parse(scanner.nextLine());
	                    System.out.print("Time (HH:MM): ");
	                    LocalTime time = LocalTime.parse(scanner.nextLine());
	                    System.out.print("Total Seats: ");
	                    int totalSeats = Integer.parseInt(scanner.nextLine());
	                    System.out.print("Ticket Price: ");
	                    float ticketPrice = Float.parseFloat(scanner.nextLine());
	                    System.out.print("Event Type (Movie/Concert/Sports): ");
	                    String eventType = scanner.nextLine();
	                    System.out.print("Venue Name: ");
	                    String venueName = scanner.nextLine();

	                    ticketBookingSystem.createEvent(eventName, date, time, totalSeats, ticketPrice, eventType, venueName);
	                    break;

	                case "bookTickets":
	                    System.out.print("Enter event name to book tickets: ");
	                    String bookEventName = scanner.nextLine();
	                    Event bookEvent = ticketBookingSystem.events.get(bookEventName);
	                    if (bookEvent != null) {
	                        System.out.print("Enter the number of tickets to book: ");
	                        int numTickets = Integer.parseInt(scanner.nextLine());
	                        ticketBookingSystem.bookTickets(bookEvent, numTickets);
	                        System.out.println("Tickets booked successfully!");
	                    } else {
	                        System.out.println("Event not found.");
	                    }
	                    break;

	                case "cancelTickets":
	                    System.out.print("Enter event name to cancel tickets: ");
	                    String cnevtnm = scanner.nextLine();
	                    Event cancelEvent = ticketBookingSystem.events.get(cnevtnm);
	                    if (cancelEvent != null) {
	                        System.out.print("Enter the number of tickets to cancel: ");
	                        int numtickets = Integer.parseInt(scanner.nextLine());
	                        ticketBookingSystem.cancelTickets(cancelEvent, numtickets);
	                        System.out.println("Tickets canceled successfully!");
	                    } else {
	                        System.out.println("Event not found.");
	                    }
	                    break;

	                case "getAvailableSeats":
	                    System.out.print("Enter event name to get available seats: ");
	                    String getstent = scanner.nextLine();
	                    Event getSeatsEvent = ticketBookingSystem.events.get(getstent);
	                    if ( getSeatsEvent != null) {
	                        int availableSeats = ticketBookingSystem.getAvailableSeats( getSeatsEvent);
	                        if (availableSeats >= 0) {
	                            System.out.println("Available seats: " + availableSeats);
	                        }
	                    } else {
	                        System.out.println("Event not found.");
	                    }
	                    break;

	                case "exit":
	                    scanner.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid command. Try again.");
	                    break;
	            }
	        }
	    }
	} 
} 
 