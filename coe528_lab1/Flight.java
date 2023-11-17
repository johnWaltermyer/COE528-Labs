package lab1;
/**
 * @author ur_dad
*/

public class Flight {
    
    private int flightNumber;    
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;    
    private double originalPrice;
    
    private int numberOfSeatsLeft;

    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        
        if(origin.equals(destination)){
            throw new IllegalArgumentException("plane cannot fly when origin and destination are the same!");
        }
        
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = numberOfSeatsLeft;
        this.originalPrice = originalPrice;
        
        this.numberOfSeatsLeft = this.capacity;
    }
    
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        String flightInfo = "Flight " + this.flightNumber + ", " + this.origin + " to " + this.destination + ", " + this.departureTime + ", original price: " + this.originalPrice + "$";
        return flightInfo;
    }
    
    // Getters
    public int getFlightNumber() {
        return flightNumber;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }
    public double getOriginalPrice() {
        return originalPrice;
    }
    
    // Setters
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }       
    
}