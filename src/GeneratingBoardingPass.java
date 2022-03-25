import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GeneratingBoardingPass {

    public static void main(String[] args) throws ParseException, IOException {
	// write your code here
        String name;
        String email;
        String phoneNumber;
        String gender;
        int age;
        String date;
        String departure;
        String destination;
        String departureTime;

        double ticketPrice= 0;
        String ETA = "";

        final int Max = 99999999;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name: ");
        name = scanner.nextLine();
//        name = "Khang Duc Nguyen"
        System.out.println("Enter your email: ");
        email = scanner.nextLine();
//        email = "noozip2241993@gmail.com";
        System.out.println("Enter your phone number: ");
        phoneNumber = scanner.nextLine();
//        phoneNumber = "7148372804";
        System.out.println("Enter your gender(male, female, or other): ");
        gender = scanner.nextLine();
//        gender ="female";
        System.out.println("Enter your age: ");
        age = scanner.nextInt();

        System.out.println("Enter your date in format of dd/mm/yyyy: ");
//        String userDate = "6/6/2022";
        String userDate = scanner.next();
        date =new SimpleDateFormat("dd/MM/yyyy").parse(userDate).toString().substring(0,10);


        Scanner anotherScanner = new Scanner(System.in);
//        date = scanner.nextLine();
        System.out.println("Your departure: Los Angeles ");
        departure = "Los Angeles";
//        departure = scanner.nextLine();
        System.out.println("Enter your destination: ");
//        destination = "London";
        destination = anotherScanner.nextLine();
        System.out.println("Enter your departure time in format of hh:mm: ");
//        departureTime = " 12:30";

        departureTime = anotherScanner.nextLine();
        departureTime = " " + departureTime;

        Random rand = new Random();
        int boardingPassNumber = rand.nextInt(Max) ;

        ArrayList<String> listFlights = (ArrayList<String>) Files.readAllLines(Paths.get("destination.txt"));
        ArrayList<String> flightLengthList = new ArrayList<>();
        ArrayList<String> ticketPriceList = new ArrayList<>();
        String[] flightInfo;

        for(var c : listFlights){
            flightInfo = c.split(",");
            flightLengthList.add(flightInfo[1]);
            ticketPriceList.add(flightInfo[2]);
        }


        switch(destinationNum) {
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

        UserInformation user1 = new UserInformation(name,boardingPassNumber,ticketPrice,ETA,email,phoneNumber,gender,age,date,departure,
                destination,departureTime);
        System.out.println(user1.toString());
        writeToTextFile(name, user1);

    }
    public static Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    private static void writeToTextFile(String name, UserInformation user1) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<>();
        list.add(user1.toString());
        Files.write(Paths.get(""+name+".txt"), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
