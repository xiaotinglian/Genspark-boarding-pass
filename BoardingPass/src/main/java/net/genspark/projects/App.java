package net.genspark.projects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class App {

    private static final String FILENAME = "resources/info.csv";
    private static final String SEPARATOR = System.getProperty("line.separator");

    public static void saveInfo(ArrayList<String> data) {
        File f = new File(FILENAME);
        try {
            FileWriter fw = (f.exists()) ? new FileWriter(f, true) : new FileWriter(f);
            fw.write(String.join(",", data) + SEPARATOR);
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] getDefaultDates() {
        LocalDate today = LocalDate.now();
        return LocalDate.now().datesUntil(
                LocalDate.of(today.getYear() + 1, today.getMonthValue(), today.getDayOfMonth()))
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gooey());
    }

}
