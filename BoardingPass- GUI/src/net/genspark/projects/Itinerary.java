package net.genspark.projects;

public class Itinerary {
    private int passNumber;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String age;
    private String city;
    private String state;
    private String gender;
    private String date;
    private String departureTime;
    private String price;
    private String ETA;

    public Itinerary() {
    }

    public Itinerary(int passNumber, String lastName, String firstName, String email, String phoneNumber, String age, String city, String state, String gender, String date, String departureTime, String price, String ETA) {
        this.passNumber = passNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.city = city;
        this.state = state;
        this.gender = gender;
        this.date = date;
        this.departureTime = departureTime;
        this.price=price;
        this.ETA=ETA;
    }

    @Override
    public String toString() {
        return "passNumber=" + passNumber +
                "\nlastName='" + lastName + '\'' +
                "\nfirstName='" + firstName + '\'' +
                "\nemail='" + email + '\'' +
                "\nphoneNumber='" + phoneNumber + '\'' +
                "\nage='" + age + '\'' +
                "\ncity='" + city + '\'' +
                "\nstate='" + state + '\'' +
                "\ngender='" + gender + '\'' +
                "\ndate='" + date + '\'' +
                "\ndepartureTime='" + departureTime + '\'' +
                "\nprice='" + price + '\'' +
                "\nETA='" + ETA + '\'';
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }
}
