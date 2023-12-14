package com.srccodes.example;
import java.time.LocalDate;
import java.time.LocalTime;

public class Inheritance {
	

	// Enums for Genre and Concert Type
	enum Genre {
	    Action, Comedy, Horror
	}

	enum ConcertType {
	    Theatrical, Classical, Rock, Recital
	}

	class Movie extends Event {
	    private Genre genre;
	    private String actorName;
	    private String actressName;

	    // Default Constructor
	    public Movie() {
	    	
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

	class Concert extends Event {
	    private String artist;
	    private ConcertType type;

	    // Default Constructor
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

	class Sports extends Event {
	    private String sportName;
	    private String teamsName;

	    // Default Constructor
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

	class TicketBookingSystem {
	    public Event createEvent(String eventName, LocalDate date, LocalTime time, int totalSeats, float ticketPrice, String eventType, String venueName) {
	        EventType type = EventType.valueOf(eventType);
	        switch (type) {
	            case Movie:
	                return new Movie(eventName, date, time, venueName, totalSeats, ticketPrice, Genre.Action, "abc", "abby");
	            case Concert:
	                return new Concert(eventName, date, time, venueName, totalSeats, ticketPrice, "Artist Name", ConcertType.Rock);
	            case Sports:
	                return new Sports(eventName, date, time, venueName, totalSeats, ticketPrice, "Football", "India vs Pakistan");
	            default:
	                return null;
	        }
	    }

	    public void displayEventDetails(Event event) {
	        event.displayEventDetails();
	    }

	    public float bookTickets(Event event, int numTickets) {
	        if (event.getAvailableSeats() >= numTickets) {
	            event.bookTickets(numTickets);
	            return (float) event.getTicketPrice()*numTickets;
	        } else {
	            System.out.println("Event is sold out. Cannot book tickets.");
	            return 0;
	        }
	    }

	    public void cancelTickets(Event event, int numTickets) {
	        event.cancelBooking(numTickets);
	    }
	}

	 

}
