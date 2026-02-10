package javaproject3;

import java.io.*;
import java.util.Scanner;

public abstract class Property implements Commissionable {
    protected int pid;
    protected String paddress;
    protected double price;

    protected static String agencyName;
    protected static double baseCommissionPercent;

    static {
        agencyName = "Laksh Real Estate";
        baseCommissionPercent = 2.0; // 2%
    }

    public Property() {}

    public Property(int pid, String paddress, double price) throws InvalidPriceException {
        if (price <= 0) {
            throw new InvalidPriceException("Price must be greater than zero.");
        }
        this.pid = pid;
        this.paddress = paddress;
        this.price = price;
    }

    // Accept Scanner from Main
    public void input(Scanner sc) {
        try {
            System.out.print("Enter Property ID: ");
            this.pid = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Property Address: ");
            this.paddress = sc.nextLine();

            System.out.print("Enter Property Price: ");
            double tempPrice = sc.nextDouble();

            if (tempPrice <= 0) {
                throw new InvalidPriceException("Price cannot be negative or zero.");
            }
            this.price = tempPrice;

        } catch (InvalidPriceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // clear buffer
        }
    }

    public void display() {
        System.out.println("\n--- Property Details ---");
        System.out.println("Agency: " + agencyName);
        System.out.println("Property ID: " + pid);
        System.out.println("Address: " + paddress);
        System.out.println("Price: " + price);
        System.out.printf("Commission: %.2f\n", calculateCommission());
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("properties.txt", true))) {
            writer.write(pid + "," + paddress + "," + price + "," + calculateCommission());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
