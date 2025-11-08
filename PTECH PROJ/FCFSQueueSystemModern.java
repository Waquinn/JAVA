import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class FCFSQueueSystemModern {
    private JFrame frame;
    private JTextField inputField;
    private DefaultListModel<String> queueModel;
    private JList<String> queueList;
    private JLabel nowServingLabel;
    private JLabel estimatedTimeLabel;
    private LinkedList<QueueEntry> queue;

    private static final int ESTIMATED_TIME_PER_PERSON = 2; // minutes

    public FCFSQueueSystemModern() {
        queue = new LinkedList<>();

        frame = new JFrame("🌟 FCFS Queue System 🌟");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout(20, 20));
        frame.getContentPane().setBackground(Color.decode("#f5f7fa"));

        // Top Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBackground(Color.decode("#f5f7fa"));
        inputField = new JTextField(20);
        inputField.setFont(new Font("Poppins", Font.PLAIN, 14));
        JButton addButton = new JButton("➕ Add to Queue");
        addButton.setFont(new Font("Poppins", Font.BOLD, 14));
        addButton.setBackground(Color.decode("#4CAF50"));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addToQueue());
        topPanel.add(inputField);
        topPanel.add(addButton);

        // Center Panel
        queueModel = new DefaultListModel<>();
        queueList = new JList<>(queueModel);
        queueList.setFont(new Font("Poppins", Font.PLAIN, 14));
        queueList.setBackground(Color.WHITE);
        queueList.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scrollPane = new JScrollPane(queueList);
        scrollPane.setPreferredSize(new Dimension(450, 300));

        JButton serveButton = new JButton("✅ Serve Next");
        serveButton.setFont(new Font("Poppins", Font.BOLD, 16));
        serveButton.setBackground(Color.decode("#2196F3"));
        serveButton.setForeground(Color.WHITE);
        serveButton.setFocusPainted(false);
        serveButton.addActionListener(e -> serveNext());

        // Bottom Panel
        nowServingLabel = new JLabel("Now Serving: None", SwingConstants.CENTER);
        nowServingLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        nowServingLabel.setForeground(Color.decode("#333333"));

        estimatedTimeLabel = new JLabel("Estimated Waiting Time: 0 minutes", SwingConstants.CENTER);
        estimatedTimeLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
        estimatedTimeLabel.setForeground(Color.decode("#555555"));

        // Center layout
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(Color.decode("#f5f7fa"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(serveButton, BorderLayout.SOUTH);

        // Full Layout
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        bottomPanel.setBackground(Color.decode("#f5f7fa"));
        bottomPanel.add(nowServingLabel);
        bottomPanel.add(estimatedTimeLabel);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    private void addToQueue() {
        String name = inputField.getText().trim();
        if (!name.isEmpty()) {
            QueueEntry entry = new QueueEntry(name, LocalDateTime.now());
            queue.add(entry);
            queueModel.addElement(formatEntry(entry));
            inputField.setText("");
            updateEstimatedTime();
        }
    }

    private void serveNext() {
        if (!queue.isEmpty()) {
            QueueEntry served = queue.removeFirst();
            queueModel.remove(0);
            nowServingLabel.setText("Now Serving: " + served.name);
            updateEstimatedTime();
        } else {
            nowServingLabel.setText("Now Serving: None");
            estimatedTimeLabel.setText("Estimated Waiting Time: 0 minutes");
        }
    }

    private void updateEstimatedTime() {
        int waitingPeople = queue.size();
        int estimatedMinutes = waitingPeople * ESTIMATED_TIME_PER_PERSON;
        estimatedTimeLabel.setText("Estimated Waiting Time: " + estimatedMinutes + " minutes");
    }

    private String formatEntry(QueueEntry entry) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return entry.name + " (Joined: " + entry.time.format(formatter) + ")";
    }

    private static class QueueEntry {
        String name;
        LocalDateTime time;

        QueueEntry(String name, LocalDateTime time) {
            this.name = name;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FCFSQueueSystemModern::new);
    }
}
