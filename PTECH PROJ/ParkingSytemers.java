import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParkingSytemers {

    private JFrame frame;
    private double parkingFee;
    private String vehicleType;
    private String overnightChoice;
    private JPanel mainPanel;
    private ArrayList<String> parkedVehicles;
    private JTextArea parkedVehiclesArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParkingSystem().createAndShowGUI());
    }

    public ParkingSytemers() {
        parkedVehicles = new ArrayList<>();
    }

    public void createAndShowGUI() {
        frame = new JFrame("Parking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);  // Center the frame

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the UI components
        createControlPanel();

        // Display the main panel
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        // Buttons for vehicle selection
        JButton addCarButton = new JButton("Add Car");
        JButton addMotorcycleButton = new JButton("Add Motorcycle");
        JButton checkoutButton = new JButton("Checkout");

        addCarButton.addActionListener(e -> handleAddVehicle("Car"));
        addMotorcycleButton.addActionListener(e -> handleAddVehicle("Motorcycle"));
        checkoutButton.addActionListener(e -> handleCheckout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addCarButton);
        buttonPanel.add(addMotorcycleButton);
        buttonPanel.add(checkoutButton);

        // Text area to show parked vehicles
        parkedVehiclesArea = new JTextArea(10, 25);
        parkedVehiclesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(parkedVehiclesArea);

        controlPanel.add(buttonPanel);
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(new JLabel("Parked Vehicles:"));
        controlPanel.add(scrollPane);

        mainPanel.add(controlPanel, BorderLayout.WEST);
    }

    private void handleAddVehicle(String vehicle) {
        vehicleType = vehicle;

        int response = JOptionPane.showConfirmDialog(frame, "Do you need overnight parking?",
                "Overnight Parking", JOptionPane.YES_NO_OPTION);
        overnightChoice = (response == JOptionPane.YES_OPTION) ? "Yes" : "No";

        calculateParkingFee();

        parkedVehicles.add(vehicleType + " - " + (overnightChoice.equals("Yes") ? "Overnight" : "Regular"));
        updateParkedVehiclesList();
    }

    private void calculateParkingFee() {
        double fee = 0;

        if ("Car".equals(vehicleType)) {
            fee = "Yes".equals(overnightChoice) ? 250 : 70;
        } else if ("Motorcycle".equals(vehicleType)) {
            fee = "Yes".equals(overnightChoice) ? 100 : 30;
        }

        parkingFee = fee;
        showReceipt();
    }

    private void showReceipt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy- MM - dd HH : mm : ss");
        String dateStr = sdf.format(new Date());

        String receipt = "----- Parking Receipt -----\n"
                + "Vehicle Type: " + vehicleType + "\n"
                + "Parking Type: " + (overnightChoice.equals("Yes") ? "Overnight" : "Regular") + "\n"
                + "Fee: ₱" + parkingFee + "\n"
                + "Date & Time: " + dateStr;

        JOptionPane.showMessageDialog(frame, receipt, "Parking Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleCheckout() {
        if (parkedVehicles.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No vehicles parked.", "Checkout", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] vehicleArray = parkedVehicles.toArray(new String[0]);
        String selectedVehicle = (String) JOptionPane.showInputDialog(frame, "Select vehicle to checkout:",
                "Checkout", JOptionPane.PLAIN_MESSAGE, null, vehicleArray, vehicleArray[0]);

        if (selectedVehicle != null) {
            parkedVehicles.remove(selectedVehicle);
            updateParkedVehiclesList();
            JOptionPane.showMessageDialog(frame, selectedVehicle + " has been checked out.", "Checkout Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateParkedVehiclesList() {
        StringBuilder vehiclesList = new StringBuilder();
        for (String vehicle : parkedVehicles) {
            vehiclesList.append(vehicle).append("\n");
        }
        parkedVehiclesArea.setText(vehiclesList.toString());
    }
}
