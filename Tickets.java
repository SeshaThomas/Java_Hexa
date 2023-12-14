package com.srccodes.example;

import java.util.Scanner;

public class Tickets {
   
	
	public static void checking(int AvailableTickets, int bookingtickets){
		if(AvailableTickets>=bookingtickets) {
			 int result=AvailableTickets-bookingtickets;
			System.out.println("Ticket available and remaining tickets "+result);
		}
		else {
			System.out.println("Tickets unavailable ,Available tickets :"+AvailableTickets);
		}
	}
	
	
	
	
 public static float calcTotalPrice(int ticketType,int bookingtickets,float silver,float gold, float diamond) {
	 float baseTicketPrice=0;
 
	switch (ticketType) {
    case 1:
        baseTicketPrice = silver;
        break;
    case 2:
        baseTicketPrice = gold;
        break;
    case 3:
        baseTicketPrice = diamond;
        break;
    default:
    	System.out.println("Booking not possible");
	}
	return baseTicketPrice * bookingtickets;
 }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the no.of available tickets: ");
		Scanner sc=new Scanner(System.in);
		
		int AvailableTickets=sc.nextInt();
		System.out.println("Enter the no.of tickets to be booked: ");
		int bookingtickets=sc.nextInt();
		
		checking( AvailableTickets, bookingtickets);
		 float silver = 150;
		 float gold = 200;
		 float diamond = 250;
		 System.out.println("Enter the ticket type btw 1 or 2 or 3: ");
		 
		 int ticketType=sc.nextInt();
		float TotalCost=calcTotalPrice(ticketType,bookingtickets,silver,gold,diamond);
	System.out.println("Total Cost :"+TotalCost); 
	
	
         }
		
	} 


 