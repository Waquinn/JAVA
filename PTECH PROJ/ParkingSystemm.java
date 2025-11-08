import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingSystemm {

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParkingSystem().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame("Parking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);

        // Show Parking Service Pricelist and Terms at the start
        showPricelistAndTerms();
    }

    // Method to display the parking service pricelist and terms
    private void showPricelistAndTerms() {
        String pricelistAndTerms = 
            "🏢 MALL PARKING SERVICE PRICELIST\n\n" +
            "🔵 Regular Parking Rates\n" +
            "First 3 hours: ₱50\n" +
            "Succeeding hourly rate: ₱20 per hour\n" +
            "Lost Ticket Penalty: ₱500 + Parking Fee\n\n" +
            "🔵 Motorcycle Parking\n" +
            "First 3 hours: ₱20\n" +
            "Succeeding hourly rate: ₱10 per hour\n" +
            "Lost Ticket Penalty: ₱300 + Parking Fee\n\n" +
            "🔵 Overnight Parking\n" +
            "(10:00 PM - 6:00 AM)\n" +
            "₱250 flat rate (regular vehicles)\n" +
            "₱100 flat rate (motorcycles)\n\n" +
            "🔵 Terms & Reminders\n\n" +
            "Parking fees are non-refundable.\n" +
            "Please secure your valuables. The management is not liable for any loss or damages.\n" +
            "Lost tickets must present valid ID and vehicle proof of ownership.\n" +
            "Overnight parking without prior notice may incur additional charges.";

        JTextArea textArea = new JTextArea(pricelistAndTerms);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger font size for better visibility
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(800, 600));

        JDialog dialog = new JDialog(frame, "Parking Service Pricelist & Terms", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        // After viewing the pricelist, proceed with the transaction
        showTransactionProcess();
    }

    // Method to handle transaction process
    public void showTransactionProcess() {
        // Ask for vehicle type
        String[] vehicleOptions = {"Car", "Motorcycle"};
        String vehicleType = (String) JOptionPane.showInputDialog(frame, "Select Vehicle Type:", 
                                                                 "Vehicle Type", JOptionPane.QUESTION_MESSAGE, 
                                                                 null, vehicleOptions, vehicleOptions[0]);

        if (vehicleType == null) {
            return; // User canceled the dialog
        }

        // Ask if overnight parking
        String[] overnightOptions = {"Yes", "No"};
        String overnightChoice = (String) JOptionPane.showInputDialog(frame, "Overnight Parking?", 
                                                                     "Overnight Parking", JOptionPane.QUESTION_MESSAGE, 
                                                                     null, overnightOptions, overnightOptions[1]);

        // Calculate parking fee
        double parkingFee = 0;
        if ("Car".equals(vehicleType)) {
            if ("Yes".equals(overnightChoice)) {
                parkingFee = 250; // Flat rate for overnight car parking
            } else {
                int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter number of hours parked:"));
                parkingFee = (hours <= 3) ? 50 : 50 + (hours - 3) * 20; // First 3 hours: ₱50, succeeding: ₱20/hour
            }
        } else if ("Motorcycle".equals(vehicleType)) {
            if ("Yes".equals(overnightChoice)) {
                parkingFee = 100; // Flat rate for overnight motorcycle parking
            } else {
                int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter number of hours parked:"));
                parkingFee = (hours <= 3) ? 20 : 20 + (hours - 3) * 10; // First 3 hours: ₱20, succeeding: ₱10/hour
            }
        }

        // Generate receipt
        String receipt = generateReceipt(vehicleType, overnightChoice, parkingFee);

        // Show receipt in a dialog
        JTextArea receiptArea = new JTextArea(receipt);
        receiptArea.setFont(new Font("Arial", Font.PLAIN, 16));
        receiptArea.setEditable(false);
        receiptArea.setBackground(Color.WHITE);

        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BorderLayout());
        receiptPanel.add(new JScrollPane(receiptArea), BorderLayout.CENTER);
        receiptPanel.setPreferredSize(new Dimension(600, 400));

        JDialog receiptDialog = new JDialog(frame, "Parking Receipt", true);
        receiptDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        receiptDialog.getContentPane().add(receiptPanel);
        receiptDialog.pack();
        receiptDialog.setLocationRelativeTo(frame);
        receiptDialog.setVisible(true);
    }

    // Method to generate the receipt content
    private String generateReceipt(String vehicleType, String overnightChoice, double parkingFee) {
        // Get current timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());

        // Create receipt content
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("🏢 MALL PARKING SERVICE RECEIPT\n\n")
                      .append("Date & Time: ").append(timestamp).append("\n\n")
                      .append("Vehicle Type: ").append(vehicleType).append("\n")
                      .append("Overnight Parking: ").append(overnightChoice).append("\n\n")
                      .append("Parking Fee: ₱").append(parkingFee).append("\n\n")
                      .append("Thank you for choosing our parking service!\n")
                      .append("Please keep this receipt for your checkout or penalty\n")
                      .append("purposes. Have a great day!");

        return receiptBuilder.toString();
    }
}
