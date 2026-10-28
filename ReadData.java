package com.mycompany.mccallum_module3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

    public static void main(String[] args) {

        try {
            File file = new File("McCallum_datafile.dat");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}