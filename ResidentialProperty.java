package javaproject3;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ResidentialProperty extends Property {
    private int bedrooms;

    public ResidentialProperty() {}

    public ResidentialProperty(int pid, String address, double price, int bedrooms)
            throws InvalidPriceException {
        super(pid, address, price);
        this.bedrooms = bedrooms;
    }

    @Override
    public double calculateCommission() {
        return (price * baseCommissionPercent) / 100;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc); // use parent input
        System.out.print("Enter number of bedrooms: ");
        bedrooms = sc.nextInt();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Bedrooms: " + bedrooms);
    }

    @Override
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("properties.txt", true))) {
            writer.write(pid + "," + paddress + "," + price + "," + bedrooms + "," + calculateCommission());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}