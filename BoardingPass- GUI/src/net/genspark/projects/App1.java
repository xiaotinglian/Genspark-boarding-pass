package net.genspark.projects;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public class App1 {

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
    public static String getBoardingPassNumber() throws IOException {
        int boardingPassNumber;
        int Max =999999; //can test with 4
        Random rand = new Random();
        String pathCustomer = "info.csv";
        List<String> boardingPassNumberList = new ArrayList<>();
        List<String> userList = Files.readAllLines(Paths.get(pathCustomer));
        //Find all boarding pass number and put it in to a boardingPassNumberlist
        for (String line : userList
        ) {
            String[] value =line.split(",");
            boardingPassNumberList.add(value[0].replaceAll("\\s",""));

        }

        System.out.println(boardingPassNumberList);
        //If boardingPassNumber is in boardingPassNumber list, boardingPassNumber generate again until boardingPassNumber is not in boardingPassNumberList

        while(true){
            boardingPassNumber = rand.nextInt(Max);
//            System.out.println(boardingPassNumber);
            if(!boardingPassNumberList.contains(String.valueOf(boardingPassNumber))){
                break;
            }
        }
        return String.valueOf(boardingPassNumber);
    }
    public static void writeToTextFile(String firstName,Itinerary1 user1) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<>();
        list.add(user1.toString());
        Files.write(Paths.get("customerInfo.txt"), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(firstName+".txt"), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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
        SwingUtilities.invokeLater(() -> new Gooey1());

    }
}
