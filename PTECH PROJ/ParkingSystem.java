import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class ParkingSystem {
    private JFrame frame;
    private JTextField plateNumberField;
    private DefaultListModel<String> waitingListModel;
    private JList<String> waitingList;
    private JLabel nowParkingLabel;
    private JLabel estimatedTimeLabel;
    private JLabel availableSlotsLabel;
    private LinkedList<ParkingEntry> queue;

    private static final int MAX_SLOTS = 5;
    private static final int ESTIMATED_TIME_PER_CAR = 3; // minutes per car
    private int availableSlots = MAX_SLOTS;

    private static final int REGULAR_CAR_RATE = 50;
    private static final int REGULAR_MOTORCYCLE_RATE = 20;
    private static final int OVERNIGHT_CAR_RATE = 250;
    private static final int OVERNIGHT_MOTORCYCLE_RATE = 100;

    public ParkingSystem() {
        // Show Pricelist and Terms & Conditions at the start
        showPricelistAndTerms();

        queue = new LinkedList<>();

        frame = new JFrame("🚗 Smart Parking System 🚗");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 850);
        frame.setLayout(new BorderLayout(20, 20));
        frame.getContentPane().setBackground(Color.decode("#e0f7fa"));

        // Top Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBackground(Color.decode("#e0f7fa"));
        plateNumberField = new JTextField(20);
        plateNumberField.setFont(new Font("Poppins", Font.PLAIN, 14));
        JButton addButton = new JButton("➕ Add Car");
        addButton.setFont(new Font("Poppins", Font.BOLD, 14));
        addButton.setBackground(Color.decode("#00796B"));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addCarToQueue());
        topPanel.add(plateNumberField);
        topPanel.add(addButton);

        // Center Panel
        waitingListModel = new DefaultListModel<>();
        waitingList = new JList<>(waitingListModel);
        waitingList.setFont(new Font("Poppins", Font.PLAIN, 14));
        waitingList.setBackground(Color.WHITE);
        waitingList.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(waitingList);
        scrollPane.setPreferredSize(new Dimension(3000, 3000));

        JButton parkCarButton = new JButton("✅ Park Next Car");
        parkCarButton.setFont(new Font("Poppins", Font.BOLD, 25));
        parkCarButton.setBackground(Color.decode("#0288D1"));
        parkCarButton.setForeground(Color.WHITE);
        parkCarButton.setFocusPainted(false);
        parkCarButton.addActionListener(e -> parkNextCar());

        // Bottom Panel
        nowParkingLabel = new JLabel("Now Parking: None", SwingConstants.CENTER);
        nowParkingLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        nowParkingLabel.setForeground(Color.decode("#333333"));

        estimatedTimeLabel = new JLabel("Estimated Waiting Time: 0 minutes", SwingConstants.CENTER);
        estimatedTimeLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        estimatedTimeLabel.setForeground(Color.decode("#555555"));

        availableSlotsLabel = new JLabel("Available Slots: " + availableSlots + "/" + MAX_SLOTS, SwingConstants.CENTER);
        availableSlotsLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        availableSlotsLabel.setForeground(Color.decode("#555555"));

        // Center layout
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(Color.decode("#e0f7fa"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(parkCarButton, BorderLayout.SOUTH);

        // Full Layout
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        bottomPanel.setBackground(Color.decode("#e0f7fa"));
        bottomPanel.add(nowParkingLabel);
        bottomPanel.add(estimatedTimeLabel);
        bottomPanel.add(availableSlotsLabel);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

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
            textArea.setFont(new Font("Poppins", Font.PLAIN, 25)); // Larger font size
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setCaretPosition(0);
            textArea.setEditable(false);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(textArea, BorderLayout.CENTER);
            panel.setPreferredSize(new Dimension(5000, 5000));

        JOptionPane.showMessageDialog(frame, pricelistAndTerms, "Parking Service Pricelist & Terms", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addCarToQueue() {
        String plateNumber = plateNumberField.getText().trim();
        if (!plateNumber.isEmpty()) {
            showVehicleTypeDialog(plateNumber);
        }
    }

    private void showVehicleTypeDialog(String plateNumber) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Select Vehicle Type:"));

        JButton carButton = new JButton("Car");
        carButton.addActionListener(e -> handleParkingType(plateNumber, "Car"));
        JButton motorcycleButton = new JButton("Motorcycle");
        motorcycleButton.addActionListener(e -> handleParkingType(plateNumber, "Motorcycle"));

        panel.add(carButton);
        panel.add(motorcycleButton);

        JOptionPane.showOptionDialog(frame, panel, "Vehicle Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
    }

    private void handleParkingType(String plateNumber, String vehicleType) {
        int parkingRate = (vehicleType.equals("Car")) ? REGULAR_CAR_RATE : REGULAR_MOTORCYCLE_RATE;
        String message = "Your vehicle type: " + vehicleType + "\nParking Rate: ₱" + parkingRate;

        int option = JOptionPane.showConfirmDialog(frame, message + "\nDo you want overnight parking?", "Overnight Parking", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            int overnightRate = (vehicleType.equals("Car")) ? OVERNIGHT_CAR_RATE : OVERNIGHT_MOTORCYCLE_RATE;
            parkingRate = overnightRate;
        }

        ParkingEntry entry = new ParkingEntry(plateNumber, LocalDateTime.now(), vehicleType, parkingRate);
        queue.add(entry);
        waitingListModel.addElement(formatEntry(entry));
        plateNumberField.setText("");
        updateEstimatedTime();
        generateReceipt(entry);
    }

    private void generateReceipt(ParkingEntry entry) {
        String receipt = "🚗 Parking Receipt 🚗\n\n" +
                         "Plate Number: " + entry.plateNumber + "\n" +
                         "Vehicle Type: " + entry.vehicleType + "\n" +
                         "Arrival Time: " + entry.time.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n" +
                         "Parking Fee: ₱" + entry.parkingRate + "\n" +
                         "Thank you for using our parking service!";

        JOptionPane.showMessageDialog(frame, receipt, "Parking Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    private void parkNextCar() {
        if (!queue.isEmpty() && availableSlots > 0) {
            ParkingEntry car = queue.removeFirst();
            waitingListModel.remove(0);
            nowParkingLabel.setText("Now Parking: " + car.plateNumber);
            availableSlots--;
            updateEstimatedTime();
            updateAvailableSlots();
        } else if (availableSlots == 0) {
            JOptionPane.showMessageDialog(frame, "🚫 No Available Parking Slots!", "Parking Full", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateEstimatedTime() {
        int waitingCars = queue.size();
        int estimatedMinutes = waitingCars * ESTIMATED_TIME_PER_CAR;
        estimatedTimeLabel.setText("Estimated Waiting Time: " + estimatedMinutes + " minutes");
    }

    private void updateAvailableSlots() {
        availableSlotsLabel.setText("Available Slots: " + availableSlots + "/" + MAX_SLOTS);
    }

    private String formatEntry(ParkingEntry entry) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return entry.plateNumber + " (" + entry.vehicleType + ", Arrived: " + entry.time.format(formatter) + ")";
    }

    private static class ParkingEntry {
        String plateNumber;
        LocalDateTime time;
        String vehicleType;
        int parkingRate;

        ParkingEntry(String plateNumber, LocalDateTime time, String vehicleType, int parkingRate) {
            this.plateNumber = plateNumber;
            this.time = time;
            this.vehicleType = vehicleType;
            this.parkingRate = parkingRate;
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ParkingSystem::new);
    }

    public Object createAndShowGUI() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAndShowGUI'");
    }
}
