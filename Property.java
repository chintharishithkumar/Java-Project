package javaproject2;
public class Property {

	  private int pid;
	  private String paddress;
	  private double price;
	  
	  static String agencyname = "Laksh Real Estate";
	  static double baseCommissionPercent = 0.02;
	  
	  

	  public Property(int pid, String paddress) {
	    this.pid = pid;
	    this.paddress = paddress;
	    this.price = 0;
	  }

	  public Property(int pid, String paddress, double price) {
	    this.pid = pid;
	    this.paddress = paddress;
	    this.price = price;
	  }

	  public double calculateCommission() {
	    return (Property.baseCommissionPercent) * (this.price) / 100;
	  }

	  int comparePrice(Property other) {
	      if (other == null) {
	          return this.pid;
	      }
	      if (this.price >= other.price) {
	          return this.pid;
	      } else {
	          return other.pid;
	      }
	  }
	  double calculatePrice(double brokerCommissionPercent) {
	      double totalPercent = baseCommissionPercent + brokerCommissionPercent;
	      double commissionAmount = price * totalPercent / 100.0;
	      return price + commissionAmount;
	  }
	  public static double minPrice(Property[] properties) {
		  if(properties == null || properties.length ==0) {
			  return 0.0;
		  }
		  int index = 0;
		  while(index < properties.length && properties[index] == null) {
			  index++;
		  }
		  if(index == properties.length) {
			  return 0.0;
		  }
	  
	  double min = properties[index].price;

	  for (int i = index + 1; i < properties.length; i++) {
	      if (properties[i] != null && properties[i].price < min) {
	          min = properties[i].price;
	      }
	  }
	  return min;
	}
	  public static int minPriceid(Property[] properties) {
		  if(properties == null || properties.length ==0) {
			  return 0;
		  }
		  int index = 0;
		  while(index < properties.length && properties[index] == null) {
			  index++;
		  }
		  if(index == properties.length) {
			  return 0;
		  }
	  
	  double min = properties[index].price;
	  int minpid = properties[index].pid;

	  for (int i = index + 1; i < properties.length; i++) {
	      if (properties[i] != null && properties[i].price < min) {
	          min = properties[i].price;
	          minpid = properties[i].pid;
	      }
	  }
	  return minpid;
	}
	  public void display() {
	    System.out.println("Property ID: " + this.pid);
	    System.out.println("Property Address: " + this.paddress);
	    System.out.println("Price: " + this.price);

	    double comm = (Property.baseCommissionPercent) * (this.price) / 100;
	    System.out.printf("Commission is %.2f", comm);
	  }
	  }


