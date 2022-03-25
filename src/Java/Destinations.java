package Java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Destinations {

    public static void flightList() throws IOException {
        /* Creation of flight list. All flights are out of DIA, data is formatted: destination,
        flight length, ticket price.*/

        File flights = new File("src/Java/flights.txt");
        try {
            FileWriter writer = new FileWriter(flights);
            writer.write("Paris, 10, 780\n");
            writer.write("Tokyo, 16, 1542\n");
            writer.write("Seoul, 17, 1154\n");
            writer.write("Hong Kong, 26, 1982\n");
            writer.write("London, 9, 706\n");
            writer.write("Sydney, 18, 1327\n");
            writer.write("Mexico City, 4, 265\n");
            writer.write("Vancouver, 3, 421\n");
            writer.write("Los Angeles, 3, 138\n");
            writer.write("New York City, 4, 208");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void arrivalAndPrice(int departure, int destination) throws IOException {
        ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get("src/Java/flights.txt"));
        ArrayList<String> flightLengthList = new ArrayList<>();
        ArrayList<String> ticketPriceList = new ArrayList<>();
        String[] flightInfo;

        for(var c : listFlights){
            flightInfo = c.split(",");
            flightLengthList.add(flightInfo[1]);
            ticketPriceList.add(flightInfo[2]);
        }

        String ETA = "";
        int ticketPrice = 0;
        switch(destination) {
            case 1:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(0))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(0));
                break;
            case 2:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(1))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(1));
                break;
            case 3:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(2))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(2));
                break;
            case 4:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(3))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(3));
                break;
            case 5:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(4))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(4));
                break;
            case 6:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(5))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(5));
                break;
            case 7:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(6))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(6));
                break;
            case 8:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(7))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(7));
                break;
            case 9:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(8))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(8));
                break;
            case 10:
                ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate + departureTime), Integer.parseInt(flightLengthList.get(9))).toString();
                ticketPrice = Double.parseDouble(ticketPriceList.get(9));
                break;
        }
    }
}
