import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FestGuideTest {

    private FestGuide.User attendee;
    private FestGuide.User coordinator;
    private FestGuide.Event validEvent;
    private FestGuide.Event noTicketEvent;

    @BeforeEach
    public void setUp() {
        attendee = new FestGuide.User("Mary", 12345, "mary@example.com", "pswd", "attendee");
        coordinator = new FestGuide.User("Jake", 54321, "jake@example.com", "pswd", "coordinator");
        validEvent = new FestGuide.Event(001, "Valid Event", "January 1, 2025", "4:00 PM", "Main Atrium", "desc", "Circus", coordinator, 100, 5);
        noTicketEvent = new FestGuide.Event(002, "Invalid Event", "January 1, 2025", "5:00 PM", "Room 205", "desc", "Fireworks", coordinator, 0, 5);

    }

    @Test
    public void validPurchase() {
        String result = attendee.purchaseTicket(validEvent);

        // Assertions for successful purchase
        assertEquals(1, validEvent.ticketCount);
        assertEquals(99, validEvent.ticketsAvailable); // Tickets available should also decrease
        assertEquals("Ticket purchased successfully!", result);
    }

    @Test
    public void insufficientTickets() {
        String result = attendee.purchaseTicket(noTicketEvent);

        // Assertions for insufficient tickets
        assertEquals(0, noTicketEvent.ticketCount); // Ticket count should remain unchanged
        assertEquals(0, noTicketEvent.ticketsAvailable);
        assertEquals("ERROR: Sorry, no more tickets available for this event.", result);

    }

    @Test
    public void invalidUser() {
        String result = coordinator.purchaseTicket(validEvent);
        // Assertions for unauthorized user type
        assertEquals(0, validEvent.ticketCount); // Ticket count remains unchanged
        assertEquals(100, validEvent.ticketsAvailable);
        assertEquals("ERROR: You are not authorized to purchase tickets.", result);
    }
}
