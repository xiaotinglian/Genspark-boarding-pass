package net.genspark.projects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    private static final String FILENAME = "info.csv";
    private static final String SEPARATOR = System.getProperty("line.separator");

    /* -----> fields provided by user <-----
     * name = "Carl", email = "Carl@gmail.com",
     * phoneNumber = "123-123-4567", gender = "Male"
     * Age = "29" 
     * -----> trip details <-----
     * date = "3-23-2022", origin = "Miami", destination = "Portland-Oregon",
     */ 
     
     /* -----> Program-Generated fields <-----
     * estimatedTimeArrival = "15:45", departureTime = "10:45";
     * long boardingPassNumber;
     */

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
}
