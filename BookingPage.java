
package projectgroupd;

import javax.swing.*;
import java.awt.*;

public class BookingPage {

    public void openPage(Costumer customer, Payment payment, Event event) {
        JTextField quantityField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        panel.add(new JLabel("Event: " + event.getName()));
        panel.add(new JLabel("Ticket Level: " + event.getTicket().getTicketLevel()));
        panel.add(new JLabel("Ticket Price: " + event.getTicket().getTicketPrice()));

        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int option = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Booking Information",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (option != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityField.getText());

            Booking booking = new Booking(
                    customer,
                    event.getTicket(),
                    quantity,
                    payment,
                    event
            );

            booking.confirmBooking();

            JOptionPane.showMessageDialog(
                    null,
                    "Booking confirmed successfully!\nTotal before discount: " + booking.getTotal(),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Quantity must be a number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Booking Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
