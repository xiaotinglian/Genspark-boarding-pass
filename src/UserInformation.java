
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class UserInformation {
    private String name;
    private int boardingPassNumber;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String date;
    private String departure;
    private String destination;
    private String departureTime;
    private Double ticketPrice;
    private String ETA;


//    private String ETA;
    // The UserInformation constructor;
    public UserInformation(String initName,int initId,Double initTicketPrice,String initETA, String initEmail, String initPhoneNumber,String initGender,
                           int initAge, String initDate, String initDeparture, String initDestination, String initDepartureTime){
        name = initName;
        boardingPassNumber = initId;
        email = initEmail;
        phoneNumber = initPhoneNumber;
        gender = initGender;
        age = initAge;
        date = initDate;
        departure = initDeparture;
        destination = initDestination;
        departureTime = initDepartureTime;
        ticketPrice = initTicketPrice;
        ETA = initETA;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender.toLowerCase();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() throws ParseException {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {

        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public Double getTicketPrice() {

        if(getAge()<= 12){
            ticketPrice = ticketPrice/2;
        } else if(getAge()>=60){
            ticketPrice= (ticketPrice*40)/100;
        };
        if(getGender() == "female"){
            ticketPrice = (ticketPrice*75)/100;
        };

        return ticketPrice;
    }

    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }




    public String toString(){
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String result = null;
        try {
            result = "Boarding Pass Number: " + getBoardingPassNumber() +".             Date: " + getDate()
                    + "\nName: " + getName()
                    + "\nGender: " + getGender() + ". Age: " + getAge()
                    + "\nEmail: " + getEmail() + ".               Phone Number: " + getPhoneNumber()
                    + "\nOrigin: " + getDeparture()
                    + "\nDestination: " + getDestination()
                    + "\nDeparture Time: " + getDepartureTime()
                    + "\nETA: "+ getETA()
                    + "\nTicket Price: " + n.format(getTicketPrice());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


}
