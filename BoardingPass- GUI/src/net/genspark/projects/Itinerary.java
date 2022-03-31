package net.genspark.projects;

public class Itinerary {
    private String passNumber;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private int age;
    private String city;
    private String state;
    private String gender;
    private String date;
    private String departureTime;

    public Itinerary() {
    }

    public Itinerary(String passNumber, String lastName, String firstName, String email, String phoneNumber, int age, String city, String state, String gender, String date, String departureTime) {
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
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "passNumber='" + passNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
}
