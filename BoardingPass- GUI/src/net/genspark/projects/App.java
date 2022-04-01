package net.genspark.projects;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;

public class App {

    private static final String FILENAME = "info.csv";
    private static final String SEPARATOR = System.getProperty("line.separator");

    public static void saveInfo(ArrayList<String> data) throws IOException {
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

        BufferedReader input = new BufferedReader(new FileReader("info.csv"));
        String last ="";
        String line;

        while ((line = input.readLine()) != null) {
            last = line;
        }
        String[] user =last.split(",");

        Random rand = new Random();
        int boardingPassNumber = rand.nextInt(999999999) ;

        Itinerary itinerary = new Itinerary(boardingPassNumber, user[0],user[1],user[2],user[3],user[4],user[5],user[6],user[7],user[8],user[9],user[10],user[11]);
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<>();
        list.add(itinerary.toString());
        Files.write(Paths.get(""+user[0]+"_"+user[1]+".txt"), list,utf8,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    
    public static String[] getDefaultDates() {
        return LocalDate.now().datesUntil(
                LocalDate.of(2023, 5, LocalDate.now().getDayOfMonth()))
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
                ticketPrice = ticketPrice * (.60);
            } else {
                ticketPrice = ticketPrice * .85;
            }
        }
        else if (age <= 12) {
            if (gender.equals("FEMALE")) {
                ticketPrice = ticketPrice * .50;
            } else {
                ticketPrice = ticketPrice * .75;
            }
        }
        if (gender.equals("FEMALE")) {
            ticketPrice = ticketPrice * .75;
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

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(() -> new Gooey());

    }
}
