package net.genspark.projects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class App {

    private static final String FILENAME = "BoardingPass\\resources\\info.csv";
    private static final String FLIGHTS = "BoardingPass\\resources\\flight-info.txt";
    private static final String SEPARATOR = System.getProperty("line.separator");

    public static void saveInfo(ArrayList<String> data) {
        File f = new File(FILENAME);
        FileWriter fw;
        try {
            if (f.exists()) {
                fw = new FileWriter(f, true);
            } else {
                fw = new FileWriter(f);
            }
            fw.write(String.join(",", data) + SEPARATOR);
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] getDefaultDates() {
        LocalDate today = LocalDate.now();
        return LocalDate.now().datesUntil(
                LocalDate.of(today.getYear() + 1, today.getMonthValue(), today.getDayOfMonth()))
                .map(LocalDate::toString)
                .toArray(String[]::new);
    }

    public static String[] getDefaultTimes() {
        ArrayList<String> times = new ArrayList<>();
        LocalTime time = LocalTime.MIDNIGHT;
        do {
            times.add(time.toString());
            time = time.plusMinutes(30);
        } while (time.isAfter(LocalTime.MIN));
        return times.toArray(String[]::new);
    }

    public static String getTicketPrice(int destination, int age, String gender) throws IOException {
        ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get(FLIGHTS));
        ArrayList<String> ticketPriceList = new ArrayList<>();
        String[] flightInfo;

        for (var c : listFlights) {
            flightInfo = c.split(",");
            ticketPriceList.add(flightInfo[2]);
        }

        // pulling ticket price from flightInfo
        double ticketPrice = switch (destination) {
            case 0 -> Double.parseDouble(ticketPriceList.get(0));
            case 1 -> Double.parseDouble(ticketPriceList.get(1));
            case 2 -> Double.parseDouble(ticketPriceList.get(2));
            case 3 -> Double.parseDouble(ticketPriceList.get(3));
            case 4 -> Double.parseDouble(ticketPriceList.get(4));
            default -> 0;
        };

        // If/else statement to apply discounts for seniors, children, and women.
        if (age >= 60) {
            ticketPrice = (gender.equals("FEMALE")) ? ticketPrice * .85 : ticketPrice * .60;
        } else if (age <= 12) {
            ticketPrice = (gender.equals("FEMALE")) ? ticketPrice * .75 : ticketPrice * .50;
        } else {
            ticketPrice = (gender.equals("FEMALE")) ? ticketPrice * .25 : ticketPrice;
        }

        return String.valueOf(ticketPrice);
    }

    public static String getArrivalTime(int destination, String depart, String date) throws IOException {
        ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get(FLIGHTS));
        ArrayList<String> flightLengthList = new ArrayList<>();
        LocalTime departTime = LocalTime.parse(depart);
        LocalDate departDate = LocalDate.parse(date);
        LocalDateTime departure = LocalDateTime.of(departDate, departTime);
        String[] flightInfo;

        for (var c : listFlights) {
            flightInfo = c.split(",");
            flightLengthList.add(flightInfo[1]);
        }

        // Combining depart time and date to LocalDateTime and adding flight Time
        LocalDateTime ETA = switch (destination) {
            case 0 -> departure.plusHours(Long.parseLong(flightLengthList.get(0)));
            case 1 -> departure.plusHours(Long.parseLong(flightLengthList.get(1)));
            case 2 -> departure.plusHours(Long.parseLong(flightLengthList.get(2)));
            case 3 -> departure.plusHours(Long.parseLong(flightLengthList.get(3)));
            case 4 -> departure.plusHours(Long.parseLong(flightLengthList.get(4)));
            default -> departure;
        };

        return String.valueOf(ETA);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gooey());
    }
}