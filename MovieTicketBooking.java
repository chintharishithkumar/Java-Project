package javaProject;

import java.util.Scanner;
import java.util.Random;

public class MovieTicketBooking {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] name = new String[10];
        boolean[] seats = new boolean[10];
        while (true) {
            System.out.println("*****Welcome To Movie Ticket Booking Website*****");
            System.out.println("1.Book Multiple Tickets\n"
                + "2.Cancel Ticket\n"
                + "3.Show Available Seats\n"
                + "4.Show All Bookings\n"
                + "5.Exit\n");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                bookmultipletickets(name, seats, sc, rand);
            }
            else if (ch == 2) {
                cancelticket(name, seats, sc);
            }
            else if (ch == 3) {
                showavailableticket(seats);
            }
            else if (ch == 4) {
                showallBookings(name, seats);
            }
            else if (ch == 5) {
                System.out.println("*****Thank You For Using Movie Ticket Booking Website*****");
                break;
            }
            else {
                System.out.println("Enter a Valid choice");
            }
        }
        sc.close();
    }

     public static void bookmultipletickets(String[] name, boolean[] seats, Scanner sc, Random rand) {
        System.out.println("How many tickets do you need: ");
        int count = sc.nextInt();
        sc.nextLine();

        if (count > getavilableseatcount(seats)) {
            System.out.println("Only " + getavilableseatcount(seats) + " Seats available. Cannot book seats for " + count + " people");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Enter name of the person " + (i + 1) + ":");
            String nameInput = sc.nextLine();
            int seat = generateRandomAvailableSeat(seats, rand);
            if (seat != -1) {
                seats[seat] = true;
                name[seat] = nameInput;
                System.out.println("Booked seat number " + (seat + 1) + " for " + nameInput);
            } else {
                System.out.println("No available seat for " + nameInput);
            }
        }
    }

   public  static void cancelticket(String[] name, boolean[] seats, Scanner sc) {
        System.out.println("Enter name to cancel Ticket: ");
        String cancelname = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            if (seats[i] && name[i] != null && name[i].equals(cancelname)) {
                seats[i] = false;
                name[i] = null;
                System.out.println("Cancelled seat " + (i + 1) + " for " + cancelname);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No booking found for " + cancelname);
        }
    }

   public static void showavailableticket(boolean[] seats) {
        System.out.println("Available Seats:");
        boolean any = false;
        for (int i = 0; i < 10; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1));
                any = true;
            }
        }
        if (!any) {
            System.out.println("oops!! No seats available");
        }
    }

   public  static void showallBookings(String[] name, boolean[] seats) {
        System.out.println("All Bookings");
        boolean any = false;
        for (int i = 0; i < 10; i++) {
            if (seats[i]) {
                System.out.println("Seat " + (i + 1) + ": " + name[i]);
                any = true;
            }
        }
        if (!any) {
            System.out.println("No bookings yet.");
        }
    }

    public static int generateRandomAvailableSeat(boolean[] seats, Random rand) {
        for (int tries = 0; tries < 10; tries++) {
            int temp = rand.nextInt(10);
            if (!seats[temp]) {
                return temp;
            }
        }
        return -1;
    }

    public static int getavilableseatcount(boolean[] seats) {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) count++;
        }
        return count;
    }
}

