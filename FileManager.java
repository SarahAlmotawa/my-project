package projectgroupd;
import java.io.*;

import java.util.ArrayList;

import java.util.Scanner;

public class FileManager {


    public static void saveCustomer(Costumer c) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            new FileWriter("costumers.txt", true)

                    );

            writer.println(

                    c.getName() + "," +

                    c.getPhone() + "," +

                    c.getCard().getCardId() + "," +

                    c.getCard().getCardHolder() + "," +

                    c.getCard().getCVV() + "," +

                    c.getCard().getExDate()

            );

            writer.close();

        } catch (IOException e) {

            System.out.println(

                    "Error saving customer: " + e.getMessage()

            );

        }

    }

    public static ArrayList<Costumer> readCostumers() {

        ArrayList<Costumer> costumers = new ArrayList<>();

        try {

            File file = new File("costumers.txt");

            if (!file.exists()) {

                System.out.println("File not found.");

                return costumers;

            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] data = line.split(",");

                Payment card = new Payment(

                        data[2],

                        data[3],

                        data[4],

                        data[5]

                );

                Costumer costumer =

                        new Costumer(

                                data[0],

                                data[1],

                                card

                        );

                costumers.add(costumer);

            }

            input.close();

        } catch (Exception e) {

            System.out.println(

                    "Error reading costumers: " + e.getMessage()

            );

        }

        return costumers;

    }
public static void saveEvent(Event e) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            new FileWriter("events.txt", true)

                    );

            writer.println(

                    e.getName() + "," +

                    e.getContactInfo() + "," +

                    e.getCity() + "," +

                    e.getDate() + "," +

                    e.getTime() + "," +

                    e.getLocation() + "," +

                    e.getTicket().getTicketId() + "," +

                    e.getTicket().getTicketLevel() + "," +

                    e.getTicket().getTicketPrice()

            );

            writer.close();

        } catch (IOException e) {

            System.out.println(

                    "Error saving event: " + e.getMessage()

            );

        }

    }

    public static ArrayList<Event> readEvents() {

        ArrayList<Event> events = new ArrayList<>();

        try {

            File file = new File("events.txt");

            if (!file.exists()) {

                System.out.println("events.txt not found.");

                return events;

            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] data = line.split(",");

                Ticket ticket = new Ticket(

                        data[6],

                        data[7],

                        Double.parseDouble(data[8])

                );

                Event event = new Event(

                        data[0],

                        data[1],

                        data[2],

                        data[3],

                        data[4],

                        data[5],

                        ticket

                );

                events.add(event);

            }

            input.close();

        } catch (Exception e) {

            System.out.println(

                    "Error reading events: " + e.getMessage()

            );

        }

        return events;

    }

 public static void saveBooking(Booking b) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            new FileWriter("bookings.txt", true)

                    );

            writer.println(

                    b.getCustomer().getName() + "," +

                    b.getCustomer().getPhone() + "," +

                    b.getEvent().getName() + "," +

                    b.getTicket().getTicketLevel() + "," +

                    b.getQuantity() + "," +

                    b.getTotal()

            );

            writer.close();

        } catch (IOException e) {

            System.out.println(

                    "Error saving booking: " + e.getMessage()

            );

        }

    }

}

