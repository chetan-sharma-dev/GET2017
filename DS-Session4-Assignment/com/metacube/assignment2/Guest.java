package main.java.com.metacube.assignment2;
import java.util.Random;

public class Guest {
	 private String name;
	private int age;
	     
	    public Guest(String guest, int pr){
	        this.name = guest;
	        this.age = pr;
	    }
	    @Override
	    public int hashCode(){
	    	
	        int hashcode = 0;
	        hashcode = (this.age*97)%RoomController.getRoomNum();
	    
	        return hashcode;
	    }
	     
	    public boolean equals(Object obj){
	    
	        if (obj instanceof Guest) {
	            Guest pp = (Guest) obj;
	            return (pp.name.equals(this.name) && pp.age == this.age);
	        } else {
	            return false;
	        }
	    }
	     
	    public String getName() {
	        return name;
	    }
	    public void setName(String item) {
	        this.name = item;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int price) {
	        this.age = price;
	    }
	     
	    public String toString(){
	        return "item: "+name+"  price: "+age;
	    }
}
