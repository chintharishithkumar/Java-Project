package javaproject2;

import java.util.Scanner;

public class PropertyDemo {
	  public static void main(String[] arg) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter no.of Properties: ");
	    int n = sc.nextInt();
	    Property[] pr = new Property[n];
	    
	    
	    
	    for(int i=0;i<n;i++) {
	      System.out.println("Enter property ["+(i+1)+"] Details");
	      
	      System.out.println("Enter Property ID: ");
	      int pid = sc.nextInt();
	      System.out.println("Enter Property Address: ");
	      String paddress = sc.next();
	      System.out.println("Enter the price of the property: ");
	      double price = sc.nextDouble();
	      pr[i] = new Property(pid, paddress, price);
	    }
	    for(int i=0;i<pr.length;i++) {
	      System.out.println("p["+(i+1)+ "] Details");
	      pr[i].display();
	      System.out.println();
	    }
	    double min = Property.minPrice(pr);
	    System.out.println("Minimum property price: "+min);
	    int minpid = Property.minPriceid(pr);
	    System.out.println("Property ID with minimum price "+minpid);
	    sc.close();
	  }
	  

	}