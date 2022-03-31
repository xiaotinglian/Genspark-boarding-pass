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

    private static final String FILENAME = "info.csv";
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
        return LocalDate.now().datesUntil(
                LocalDate.of(2023, 4, LocalDate.now().getDayOfMonth()))
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
        ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get("Flight_Info.txt"));
        ArrayList<String> ticketPriceList = new ArrayList<>();
        String[] flightInfo;

        for (var c : listFlights) {
            flightInfo = c.split(",");
            ticketPriceList.add(flightInfo[2]);
        }

        //pulling ticket price from flightInfo
        double ticketPrice = Double.parseDouble(ticketPriceList.get(destination));

        //If/else statement to apply discounts to ticketPrice for seniors, children, and women.
        if (age >= 60) {
            if (gender.equals("FEMALE")) {
                ticketPrice = ticketPrice * (.85);
            } else {
                ticketPrice = ticketPrice * .60;
            }
        } else if (age <= 12) {
            if (gender.equals("FEMALE")) {
                ticketPrice = ticketPrice * .75;
            } else {
                ticketPrice = ticketPrice * .50;
            }
        } else {
            if (gender.equals("FEMALE")) {
                ticketPrice = ticketPrice * .25;
            }
        }
        String price = String.valueOf(ticketPrice);
     return price;
 }

 public static String getArrivalTime(int destination, String depart, String date) throws IOException {
     ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get("Flight_Info.txt"));
     ArrayList<String> flightLengthList = new ArrayList<>();
     String[] flightInfo;

     for(var c : listFlights){
         flightInfo = c.split(",");
         flightLengthList.add(flightInfo[1]);
     }

     //Combining depart time and date to LocalDateTime and adding flight Time from flightInfo
     LocalTime departTime = LocalTime.parse(depart);
     LocalDate departDate = LocalDate.parse(date);
     LocalDateTime departure = LocalDateTime.of(departDate, departTime);
     LocalDateTime ETA = departure.plusHours(Long.parseLong(flightLengthList.get(destination)));
     return String.valueOf(ETA);
 }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gooey());
    }
}
