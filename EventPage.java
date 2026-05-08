package projectgroupd;

import javax.swing.*;
import java.awt.*;

public class EventPage {

    public void openPage() {
        JTextField nameField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField locationField = new JTextField();

        JTextField ticketIdField = new JTextField();
        JTextField levelField = new JTextField();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        panel.add(new JLabel("Event Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Contact Info:"));
        panel.add(contactField);

        panel.add(new JLabel("City:"));
        panel.add(cityField);

        panel.add(new JLabel("Date:"));
        panel.add(dateField);

        panel.add(new JLabel("Time:"));
        panel.add(timeField);

        panel.add(new JLabel("Location:"));
        panel.add(locationField);

        panel.add(new JLabel("Ticket ID:"));
        panel.add(ticketIdField);

        panel.add(new JLabel("Ticket Level (Basic/VIP):"));
        panel.add(levelField);

        panel.add(new JLabel("Ticket Price:"));
        panel.add(priceField);

        int option = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Add Event",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (option != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            Ticket ticket = new Ticket(
                    ticketIdField.getText(),
                    levelField.getText(),
                    Double.parseDouble(priceField.getText())
            );

            Event event = new Event(
                    nameField.getText(),
                    contactField.getText(),
                    cityField.getText(),
                    dateField.getText(),
                    timeField.getText(),
                    locationField.getText(),
                    ticket
            );

            FileManager.saveEvent(event);

            JOptionPane.showMessageDialog(null, "Event saved successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}