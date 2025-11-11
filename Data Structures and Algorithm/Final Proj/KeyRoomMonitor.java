//javafx - more on sa GUI side, buttons textfields etc
//javaio - data gathering side, for reading and writing files
//jaavutil - for data structures used here


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.collections.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;



// --------------------- DATA STRUCTURES ----------------------

class KeyRecord {
    //Variables / Acts as the blue print ng program
    String room;
    String borrowerName;
    String borrowerProgram;
    String borrowerYearSec;
    String dateTime;

    //Constructor for the data input from the user
    KeyRecord(String room, String borrowerName, String borrowerProgram, String borrowerYearSec, String dateTime) {
        this.room = room;
        this.borrowerName = borrowerName;
        this.borrowerProgram = borrowerProgram;
        this.borrowerYearSec = borrowerYearSec;
        this.dateTime = dateTime;
    }

    @Override
    //For better display of the inputs
    public String toString() {
        return room + " - " + borrowerName + " |" + borrowerProgram + " - " + borrowerYearSec + "| [" + dateTime + "]";
    }
}

// Binary Search Tree for tracking room IDs (supports alphanumeric)
class Node {
    String room;
    Node left, right;

    Node(String room) {
        this.room = room;
    }
}


class BinarySearchTree {
    //The BST has a root starting point
    Node root;

    //Adds new room to the tree
    void insert(String room) {
        root = insertRec(root, room);
    }

    //Recursive 
    Node insertRec(Node root, String room) {
        //Creates new node if the tree is empty
        if (root == null) return new Node(room);
        if (room.compareTo(root.room) < 0) root.left = insertRec(root.left, room);
        else if (room.compareTo(root.room) > 0) root.right = insertRec(root.right, room);
        return root;
    }

    //Visits all rooms in alphabetical order
    void inorder(Node node, List<String> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.room);
            inorder(node.right, result);
        }
    }

    //Get all the list of all rooms inorder
    List<String> getInorder() {
        List<String> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    //🆕 NEW: Remove a room from the BST
    void delete(String room) {
        root = deleteRec(root, room);
    }

    Node deleteRec(Node root, String room) {
        if (root == null) return null;

        if (room.compareTo(root.room) < 0) {
            root.left = deleteRec(root.left, room);
        } else if (room.compareTo(root.room) > 0) {
            root.right = deleteRec(root.right, room);
        } else {
            // Node found - delete it
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node has two children: get smallest from right subtree
            root.room = minValue(root.right);
            root.right = deleteRec(root.right, root.room);
        }
        return root;
    }

    String minValue(Node node) {
        String min = node.room;
        while (node.left != null) {
            min = node.left.room;
            node = node.left;
        }
        return min;
    }

    //🆕 NEW: Visual tree representation
    String visualizeTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 BST Structure (Alphabetical Order):\n");
        sb.append("─────────────────────────────────────\n");
        if (root == null) {
            sb.append("  [Empty Tree]\n");
        } else {
            visualizeNode(root, "", true, sb);
        }
        return sb.toString();
    }

    void visualizeNode(Node node, String prefix, boolean isTail, StringBuilder sb) {
    if (node != null) {
        sb.append(prefix)
          .append(isTail ? "└── " : "├── ")
          .append(node.room)
          .append("\n");

        // Collect non-null children
        List<Node> children = new ArrayList<>();
        if (node.left != null) children.add(node.left);
        if (node.right != null) children.add(node.right);

        // Loop through children
        for (int i = 0; i < children.size(); i++) {
            boolean lastChild = (i == children.size() - 1);
            visualizeNode(children.get(i),
                prefix + (isTail ? "    " : "│   "),
                lastChild,
                sb
            );
        }
    }
}

}

// --------------------- MAIN APPLICATION ----------------------


//GUI
public class KeyRoomMonitor extends Application {
    //Saan masasave yung file/data
    private static final String DATA_FILE = "keys_data.txt";

    //Store or save yung mga current keys na nahiram
    private HashMap<String, KeyRecord> activeKeys = new HashMap<>();
   
    //Keep all rooms in sorted order BST
    private BinarySearchTree keyLog = new BinarySearchTree();

    //Holds all the inputs para idisplay as a list
    private ObservableList<String> listItems = FXCollections.observableArrayList();
    
    //For visual presentation ng mga nahiram na susi
    private ListView<String> listView = new ListView<>(listItems);

    //🆕 NEW: TextArea to show BST structure
    private TextArea bstVisualArea = new TextArea();

    @Override
    public void start(Stage stage) {
        loadData();


        //Text Fields
        Label title = new Label("Key Room Monitoring System");
        title.setFont(new Font("Arial", 24));

        TextField roomField = new TextField();
        roomField.setPromptText("Room No.");

        TextField nameField = new TextField();
        nameField.setPromptText("Borrower");

        TextField programField = new TextField();
        programField.setPromptText("Program");

        TextField yearSecField = new TextField();
        yearSecField.setPromptText("Year & Section");


        //Buttons
        Button addBtn = new Button("➕ Add Key");
        Button returnBtn = new Button("🔁 Return Key");
        Button refreshBtn = new Button("🔄 Refresh List");
        Button showTreeBtn = new Button("🌲 Show BST"); //🆕 NEW button

        // Components is arranged horizontally, with padding para mas maganda tignan
        HBox inputBox = new HBox(10, roomField, nameField, programField, yearSecField, addBtn, returnBtn, refreshBtn, showTreeBtn);
        inputBox.setPadding(new Insets(10));

        //🆕 NEW: BST visualization area
        bstVisualArea.setEditable(false);
        bstVisualArea.setPrefHeight(200);
        bstVisualArea.setFont(Font.font("Courier New", 12));
        bstVisualArea.setStyle("-fx-control-inner-background: #f5f5f5;");

        // Components is arranged vertically, with padding para mas maganda tignan
        VBox layout = new VBox(10, title, inputBox, new Label("📋 Active Borrowed Keys (Sorted):"), listView, bstVisualArea);
        layout.setPadding(new Insets(15));
        layout.getStyleClass().add("root");


        //Gets user input
        addBtn.setOnAction(e -> {
            //Converts room name to uppercase.
            String room = roomField.getText().trim().toUpperCase();

            //Adds a dash if needed (like converting E101 → E-101).
                if (room.matches("^[A-Z]\\d+$")) {
                    room = room.substring(0, 1) + "-" + room.substring(1);
                }
            
            String borrowerName = nameField.getText().trim();
            String program = programField.getText().trim();
            String yearSec = yearSecField.getText().trim();

            //Makes sure to fill the required fields
            if (room.isEmpty() || borrowerName.isEmpty() || program.isEmpty() || yearSec.isEmpty()) {
                showAlert("Please fill in all fields.");
                return;
            }

            //Checks if the room is already borrowed.
            if (activeKeys.containsKey(room)) {
                showAlert("Room " + room + " is already borrowed!");
                return;
            }


            //Time and Date
            ZoneId philZone = ZoneId.of("Asia/Manila");
            String time = LocalDateTime.now(philZone).format(DateTimeFormatter.ofPattern("hh:mm a dd-MM-yyyy"));

            //Creates new keyrecord, then adds it to active keys(hashmap) and keylog (BST)
            //updates the list and saves data
            //clear fields for another entry after an input is save
            KeyRecord record = new KeyRecord(room, borrowerName, program, yearSec, time);
            activeKeys.put(room, record);
            keyLog.insert(room);
            refreshList(); //🆕 Now displays in sorted order!
            updateBSTVisualization(); //🆕 Update tree view
            saveData();
            roomField.clear();
            nameField.clear();
            programField.clear();
            yearSecField.clear();
        });


        //Gets the selected key in the list.
        //🆕 CHANGED: Now also removes from BST
        //Removes it from the HashMap.
        //Updates the list and file.
        returnBtn.setOnAction(e -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Select a key to return.");
                return;
            }

            String room = selected.split(" - ")[0];
            activeKeys.remove(room);
            keyLog.delete(room); //🆕 Remove from BST too!
            refreshList();
            updateBSTVisualization(); //🆕 Update tree view
            saveData();
        });

        //Updates the list with the latest data
        refreshBtn.setOnAction(e -> refreshList());
        
        //🆕 NEW: Show BST structure button
        showTreeBtn.setOnAction(e -> updateBSTVisualization());
        
        refreshList();
        updateBSTVisualization(); //🆕 Show initial tree

        Scene scene = new Scene(layout, 1000, 700); //🆕 Increased height
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Key Room Monitor");
        stage.setResizable(false);
        stage.show();
    }

    //🆕 CHANGED: Now uses BST to display in SORTED order!
    private void refreshList() {
        listItems.clear();
        List<String> sortedRooms = keyLog.getInorder(); // Get rooms in alphabetical order
        for (String room : sortedRooms) {
            KeyRecord record = activeKeys.get(room);
            if (record != null) {
                listItems.add(record.toString());
            }
        }
    }

    //🆕 NEW: Update BST visualization
    private void updateBSTVisualization() {
        bstVisualArea.setText(keyLog.visualizeTree());
    }

    //Writes all records into a file (keys_data.txt) so they're not lost when you close the app.
    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (KeyRecord record : activeKeys.values()) {
                writer.write(record.room + "," + record.borrowerName + "," + record.borrowerProgram + "," + record.borrowerYearSec + "," + record.dateTime);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    //Reads saved data from the text file when the program starts, so previously borrowed keys are reloaded.
   // Reads saved data from the text file when the program starts, so previously borrowed keys are reloaded.
private void loadData() {
    File file = new File(DATA_FILE);
    if (!file.exists()) return;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        List<String> tempRooms = new ArrayList<>();

        // Read each line and store activeKeys and temporary room names
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 5);
            if (parts.length == 5) {
                KeyRecord record = new KeyRecord(parts[0], parts[1], parts[2], parts[3], parts[4]);
                activeKeys.put(parts[0], record);
                tempRooms.add(parts[0]); // collect rooms to build balanced BST
            }
        }

        // Sort alphabetically
        Collections.sort(tempRooms);

        // Build a balanced BST from sorted rooms
        buildBalancedBST(tempRooms, 0, tempRooms.size() - 1);

    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}

// Recursive helper to build balanced BST
private void buildBalancedBST(List<String> rooms, int start, int end) {
    if (start > end) return;

    int mid = (start + end) / 2;

    // Insert the middle element first for balanced structure
    keyLog.insert(rooms.get(mid));

    // Recursively insert left and right halves
    buildBalancedBST(rooms, start, mid - 1);
    buildBalancedBST(rooms, mid + 1, end);
}



    //Shows pop-up messages for user notifications.
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}


// java --module-path ~/javafx-sdk-23/javafx-sdk-23/lib --add-modules javafx.controls,javafx.fxml KeyRoomMonitor