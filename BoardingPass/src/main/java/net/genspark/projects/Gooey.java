package net.genspark.projects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

public class Gooey extends JFrame implements ActionListener {

    // JTextfields
    private final TextPane firstPanel = new TextPane("First-Name");
    private final TextPane lastPanel = new TextPane("Last-Name");
    private final TextPane emailPanel = new TextPane("E-Mail");
    private final TextPane numberPanel = new TextPane("Phone-Number");
    private final TextPane agePanel = new TextPane("Age");
    // JComboPanes
    private final ComboPane genderPanel = new ComboPane("Gender");
    private final ComboPane cityPanel = new ComboPane("Destination City");
    private final ComboPane statePanel = new ComboPane("Destination State");
    private final ComboPane datePanel = new ComboPane("Departure Date");
    private final ComboPane departPanel = new ComboPane("Departure-Time");

    private final ComponentPane[] allPanes = { firstPanel, lastPanel, emailPanel,
            numberPanel, agePanel, cityPanel, statePanel, genderPanel, datePanel, departPanel };

    Gooey() {
        super("LAX Boarding Pass");
        addKeyListeners();
        setModels();
        addPanels();
        initFrame();
    }

    private void addKeyListeners() {
        KeyAdapter phoneNumberListener = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                JTextField field = (JTextField) e.getSource();
                if ((e.getKeyChar() + "").matches("[\\D]") || field.getText().length() >= 11)
                    e.consume();
            }
        };
        KeyAdapter ageListener = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                JTextField field = (JTextField) e.getSource();
                if ((e.getKeyChar() + "").matches("[\\D]") || field.getText().length() >= 3)
                    e.consume();
            }
        };
        numberPanel.getField().addKeyListener(phoneNumberListener);
        agePanel.getField().addKeyListener(ageListener);
    }

    private void initFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\plane.jpg"));
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void setModels() {
        // default models change as needed
        String[] timeArray = App.getDefaultTimes();
        String[] dates = App.getDefaultDates();
        String[] genders = new String[] { "MALE", "FEMALE", "NON-BINARY" };
        String[] cities = new String[] { "New York", "Miami", "Denver", "Austin", "Chicago" };
        String[] states = new String[] { "New York", "Florida", "Colorado", "Texas", "Illinois" };
        // set the models on the combopanes
        genderPanel.setModel(genders);
        cityPanel.setModel(cities);
        statePanel.setModel(states);
        datePanel.setModel(dates);
        departPanel.setModel(timeArray);
    }

    private void addPanels() {
        GridLayout grid = new GridLayout(0, 2, 1, 1);
        // panels
        JPanel userPane = new JPanel(grid);
        JPanel tripPane = new JPanel(grid);
        // top panel
        userPane.add(firstPanel);
        userPane.add(lastPanel);
        userPane.add(emailPanel);
        userPane.add(agePanel);
        userPane.add(genderPanel);
        userPane.add(numberPanel);
        // bottom panel
        tripPane.add(statePanel);
        tripPane.add(cityPanel);
        tripPane.add(datePanel);
        tripPane.add(departPanel);
        // borders
        userPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "User Info"));
        tripPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Trip Info"));
        // add frame Components
        add(userPane);
        add(tripPane);
        add(new JSeparator(SwingConstants.HORIZONTAL));
        addButtons();

    }

    private void addButtons() {
        ActionListener resetter = (e) -> {
            Arrays.stream(allPanes).forEach(ComponentPane::reset);
            firstPanel.focus();
        };
        JPanel butnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButn = new JButton("Send");
        JButton resetButn = new JButton("Reset");
        Cursor pointer = new Cursor(Cursor.HAND_CURSOR);

        // backgrounds
        resetButn.setBackground(Color.LIGHT_GRAY);
        submitButn.setBackground(Color.CYAN);
        // Cursors
        submitButn.setCursor(pointer);
        resetButn.setCursor(pointer);
        // ActionListeners
        submitButn.addActionListener(this);
        resetButn.addActionListener(resetter);
        // addtopanel
        butnPane.add(submitButn);
        butnPane.add(resetButn);
        // add to frame
        add(butnPane);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (checkValidity()) {
            ArrayList<String> list = new ArrayList<>();
            String price, arrival;
            try {
                // alter price by gender
                price = App.getTicketPrice(cityPanel.getIndex(), Integer.parseInt(agePanel.getText()),
                        genderPanel.getText());
                // get arrival times
                arrival = App.getArrivalTime(cityPanel.getIndex(), departPanel.getText(), datePanel.getText());
                // add all pane information to list
                for (var x : allPanes)
                    list.add(x.getText());
                // add prices to list
                list.add(price);
                // add arrivaltimes to list
                list.add(arrival);
            } catch (IOException e) {
                e.printStackTrace();
            }
            generateTicket(list);
        } else {
            JOptionPane.showMessageDialog(this, "One or more fields is invalid.");
        }
    }

    private void generateTicket(ArrayList<String> bookingInfo) {
        String userMsg = "'" + bookingInfo.get(0) + " " + bookingInfo.get(1) + "' has created a new booking.";
        App.saveInfo(bookingInfo);
        JOptionPane.showMessageDialog(this, userMsg);
        System.exit(0);
    }

    private boolean checkValidity() {
        // ensures fields are not empty, highlight fields that are empty
        boolean valid = true;
        for (var x : allPanes) {
            if (x == emailPanel) {
                int emailStart = x.getText().lastIndexOf("@");
                int emailEnd = x.getText().lastIndexOf(".com");
                if (emailStart == -1 || emailEnd == -1) {
                    JOptionPane.showMessageDialog(this, "Please add an '@address.com' suffix to your email.");
                    x.setBorder(BorderFactory.createLineBorder(Color.RED));
                    valid = false;
                }
            }
            if (x == agePanel || x == numberPanel) {
                if (x.getNumbers().isBlank()) {
                    x.setBorder(BorderFactory.createLineBorder(Color.RED));
                    valid = false;
                }
            } else if (x.getText().isBlank()) {
                x.setBorder(BorderFactory.createLineBorder(Color.RED));
                valid = false;
            } else {
                x.setBorder(null);
            }
        }
        return valid;
    }
}