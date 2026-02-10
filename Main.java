package javaproject3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResidentialProperty rp = new ResidentialProperty();

        rp.input(sc);   // pass Scanner
        rp.display();
        rp.saveToFile();

        System.out.println("\nProperty data saved to file successfully!");
        sc.close();     // close properly
    }
}