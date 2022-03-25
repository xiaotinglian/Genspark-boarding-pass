package net.genspark.projects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class App {

    private static final String FILENAME = "info.csv";
    private static final String SEPARATOR = System.getProperty("line.separator");

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gooey());
    }
}
