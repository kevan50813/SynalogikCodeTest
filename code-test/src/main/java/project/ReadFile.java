package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public String data="";
    public ReadFile(String filename){
        String contnet="";
        try {
            File f = new File(filename);
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                contnet = reader.nextLine();
                data=data+contnet;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to open a file.");
            e.printStackTrace();
        }
    }

    public String getData() {
        return data;
    }
}
