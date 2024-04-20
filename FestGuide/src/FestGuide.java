// 
//
//	FestGuide class
//
// includes User, Event, and Ticket classes
//

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FestGuide {

	// User class
	public static class User {
		// User class vars
		public String name;
		public int userID;
		public String email;
		private String password;
		private String userType;
		//private Ticket[] ticketArray;
		

		// User class methods:
		User (String n, int id, String e, String p, String t) {
			name = n;
			userID = id;
			email = e;
			password = p;
			userType = t;
		}
		String purchaseTicket(Event e) {
			// make sure user is of type attendee
			if (this.userType != "attendee" ) {
				return "ERROR: You are not authorized to purchase tickets.";
			}
			// make
			else if (e.ticketsAvailable == 0) {
				return "ERROR: Sorry, no more tickets available for this event.";
			}
			else {
				// authorize payment here, get payment amount (ticketPrice) from event e and charge user (not included in method yet)
				
				e.ticketCount += 1;
				e.ticketsAvailable -= 1;
				Ticket ticket = new Ticket(000, e, this);	// create ticket
				return "Ticket purchased successfully!";
			}
			
		}
	}
	
	// Event class
	public static class Event {
		// Event class vars
		public int eventID;
		public String name;
		public String date;
		public String time;
		public String location;
		public String description;
		public String eventCategory;
		public User coordinator;
		public int ticketCount = 0;	// initial value
		public int ticketsAvailable; // Event capacity
		public int ticketPrice;
		
		// Event class methods:
		Event (int id, String n, String d, String t, String l, String desc, String category, User coord, int initial, int price ) {
			eventID = id;
			name = n;
			date = d;
			time = t;
			location = l;
			description = desc;
			eventCategory = category;
			coordinator = coord;
			ticketCount = 0;
			ticketsAvailable = initial;
			ticketPrice = price;

		}
		// rest of methods are undefined for this test
		
		
	}
	
	// Ticket class
	public static class Ticket {
		// Ticket class vars:
		public int ticketID;
		public Event event;
		public User user;
		
		// Ticket class methods:
		// initial overloaded constructor
		Ticket(int id, Event e, User u) {
			ticketID = id;
			event = e;
			user = u;
		}
		// returns ticketID
		public int getTicketID() {
			return ticketID;
		}
		// returns event
		public Event getEvent() {
			return event;
		}
		// returns user
		public User getUser() {
			return user;
		}
	}

	 
}


