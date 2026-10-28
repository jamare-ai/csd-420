/*
 * Jamare McCallum
 * CSD 420
 * Module 3
 * Creates 5 random integers and 5 random doubles
 * and writes them to McCallum_datafile.dat.
 */

import java.io.*;
import java.util.Random;

public class WriteData {

    public static void main(String[] args) {

        Random random = new Random();

        try (PrintWriter output =
                new PrintWriter(new FileWriter("McCallum_datafile.dat", true))) {

            output.println("Integers:");

            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(100);
                output.println(num);
            }

            output.println("Doubles:");

            for (int i = 0; i < 5; i++) {
                double num = random.nextDouble() * 100;
                output.println(num);
            }

            output.println("----------------");

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}