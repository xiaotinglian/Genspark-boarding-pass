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
    static Charset utf8 = StandardCharsets.UTF_8;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws ParseException, IOException {
        Files.write(Paths.get("customerInfo.txt"), list,utf8,
                StandardOpenOption.CREATE);
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
        int boardingPassNumber ;
        double ticketPrice;
        int length;
        String ETA;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your full name: ");
        name = scanner.nextLine();

        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        System.out.println("Enter your phone number: ");
        phoneNumber = scanner.nextLine();

        System.out.println("Enter your gender(male, female, or other): ");
        gender = scanner.nextLine();

        System.out.println("Enter your age: ");
        age = scanner.nextInt();

        System.out.println("Enter your date in format of dd/mm/yyyy: ");
        String userDate = scanner.next();
        date =new SimpleDateFormat("dd/MM/yyyy").parse(userDate).toString().substring(0,10);

        Scanner anotherScanner = new Scanner(System.in);
        System.out.println("Your departure: Los Angeles ");
        departure = "Los Angeles";

        System.out.println("Enter your destination: ");
        destination = anotherScanner.nextLine();

        System.out.println("Enter your departure time in format of hh:mm: ");
        departureTime = anotherScanner.nextLine();
        departureTime = " " + departureTime;


        boardingPassNumber = getBoardingPassNumber();
        ticketPrice = getTicketPrice(destination);
        length = getLength(destination);
        ETA = addHoursToJavaUtilDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate+departureTime),length).toString();
        UserInformation user1 = new UserInformation(name,boardingPassNumber,ticketPrice,ETA,email,phoneNumber,gender,age,date,departure,
                destination,departureTime);
        System.out.println(user1);

        writeToTextFile(name, user1);

    }

    private static int getBoardingPassNumber() throws IOException {
        int boardingPassNumber;
        int Max =999999;
        Random rand = new Random();
        String pathCustomer = "customerInfo.txt";
        List<Integer> boardingPassNumberList = new ArrayList<>();
        List<String> userList = Files.readAllLines(Paths.get(pathCustomer));
        for (String line : userList
        ) {
            String[] value =line.split(":");
            if(value[0].startsWith("Boarding")){
                boardingPassNumberList.add(Integer.parseInt(value[1].replaceAll("\\s","")));
            }
        }

//        System.out.println(boardingPassNumberList);
        while(true){
            boardingPassNumber = rand.nextInt(Max);
//            System.out.println(boardingPassNumber);
            if(!boardingPassNumberList.contains(boardingPassNumber)){
                break;
            }
        }
        return boardingPassNumber;
    }
    public static Double getTicketPrice(String destination) throws IOException {
        double ticketPrice =0.00;
        String path = "destination.txt";
        List<String> destinationList = Files.readAllLines(Paths.get(path));
        for (String line : destinationList
        ) {
            String[] value =line.split(",");
            if(value[0].equals(destination)){
                ticketPrice = Double.parseDouble(value[2]);
            }
        }
        return ticketPrice;
    }
    public static int getLength(String destination) throws IOException {
        String path = "destination.txt";
        List<String> destinationList = Files.readAllLines(Paths.get(path));
        int length = 0;
        for (String line : destinationList
        ) {
            String[] value =line.split(",");
            if(value[0].equals(destination)){
                length = Integer.parseInt(value[1].replaceAll("\\s",""));
            }
        }
        return length;
    }
    public static Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    private static void writeToTextFile(String name, UserInformation user1) throws IOException {
        list.add(user1.toString());
        Files.write(Paths.get("customerInfo.txt"), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        String firstName = name.split(" (?!.* )")[0];
        Files.write(Paths.get(firstName+".txt"), list,utf8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}