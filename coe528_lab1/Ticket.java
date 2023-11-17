package lab1;

/**
 * @author ur_dad
 */
class Ticket {
  private Passenger passenger;
  private Flight flight;
  private double price;
  private int number;
  private static int previousTicket = 0; //initialized to 0 (i.e., 0-th ticket). will increase to 1 when first instance of Ticket class is created.

  public Ticket(Passenger p, Flight flight, double price) {
    previousTicket++;
    this.number = previousTicket;
      
    this.passenger = p;
    this.flight = flight;
    this.price = price;
  }
  
  @Override
  public String toString(){
        return passenger.getName()+", "+flight.toString()+", ticket price: $" + price;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}

