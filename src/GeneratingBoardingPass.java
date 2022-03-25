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

        final int Max = 99999999;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name: ");
        name = scanner.nextLine();
//        name = "Khang Duc Nguyen";
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
        String path = "destination.txt";
        List<String> destinationList = Files.readAllLines(Paths.get(path));
        int length = 0;
        for (String line : destinationList
        ) {
            String[] value =line.split(",");
            if(value[0].equals(destination)){
                length = Integer.parseInt(value[1]);
                ticketPrice = Double.parseDouble(value[2]);

            }
        }
        String ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/mm/yyyy").parse(userDate+departureTime),length).toString();
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
        String userTextFile = "userInformation";
        Files.write(Paths.get(userTextFile), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
