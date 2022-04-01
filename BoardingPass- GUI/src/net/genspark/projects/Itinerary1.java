package net.genspark.projects;

import java.text.NumberFormat;
import java.util.Locale;

public class Itinerary1 {
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
    private String ETA;



    private double price;

    public Itinerary1() {
    }

    public Itinerary1(String passNumber, String lastName, String firstName, String email, String phoneNumber, int age, String city, String state, String gender, String date, String departureTime, String ETA, double price) {
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
        this.ETA = ETA;
    }

    @Override
    public String toString() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        return  "Name: " + getFirstName()+ " " + getLastName() +"\t\t\t\t\tDate: " + getDate()
                + "\nBoarding Pass Number: " + getPassNumber()
                + "\nGender: " + getGender() + ". Age: " + getAge()
                + "\nEmail: " + getEmail() + "\t\t\t\t\tPhone Number: " + getPhoneNumber()
                + "\nOrigin: " + "Los Angeles,California"
                + "\nDestination: " + getCity() +", " + getState()
                + "\nDeparture Time: " + getDepartureTime()
                + "\nETA: " + getETA()
                + "\nTicket Price: " + n.format(getPrice());
    }
    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

