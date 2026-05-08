
package projectgroupd;

public  class Event implements Displayable {

    private String name;
    private String contactInfo;
    private String city;
    private String date;
    private String time;
    private String location;
    private Ticket ticket;
    private static int eventCounter = 0;

    public Event() {
        eventCounter++;
    }

    public Event(String name, String contactInfo, String city,
                 String date, String time, String location,
                 Ticket ticket) {

        this.name = name;
        this.contactInfo = contactInfo;
        this.city = city;
        this.date = date;
        this.time = time;
        this.location = location;
        this.ticket = ticket;

        eventCounter++;
    }

    public boolean isEventFull() {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public static int getEventCounter() {
        return eventCounter;
    }

    @Override
    public void displayInfo() {
        System.out.println("Event Details[ Name: " + name +
                " | Contact Info: " + contactInfo +
                " | City: " + city +
                " | Date: " + date +
                " | Time: " + time +
                " | Location: " + location + " ]");

        if (ticket != null) {
            ticket.displayInfo();
        }
    }

    @Override
    public String toString() {
        return name + "," +
                contactInfo + "," +
                city + "," +
                date + "," +
                time + "," +
                location + "," +
                ticket.getTicketId() + "," +
                ticket.getTicketLevel() + "," +
                ticket.getTicketPrice();
    }
}


