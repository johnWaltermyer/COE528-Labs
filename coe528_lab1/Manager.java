package lab1;
/**
 * @author ur_dad
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;
    private Scanner sc;

    public Manager() {
        flights = new ArrayList<Flight>();
        tickets = new ArrayList<Ticket>();
        sc = new Scanner(System.in);
    }

    public void createFlights() {        
        System.out.println("Enter flight number (Integer): ");        
        int flightNumber;
        while(true){
            try{
                flightNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException e){
                System.out.println("Not an integer. try again: ");                
            }
        }
        System.out.println("Enter origin (String):");
        String origin = sc.nextLine();

        System.out.println("Enter destination (String):");
        String destination = sc.nextLine();

        System.out.println("Enter departure time (String):");
        String departureTime = sc.nextLine();
        
        int capacity;
        System.out.println("Enter capacity (Integer): ");
        while(true){
            try{
                capacity = Integer.parseInt(sc.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Not an integer. try again: ");                
            }
        }        

        System.out.println("Enter original price (Double):");
        double originalPrice;
        while(true){
            try{
                originalPrice = Double.parseDouble(sc.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Not a double. try again: ");                
            }
        }        

        Flight flight = new Flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);
        flights.add(flight);        
    }
    
    public void displayAvailableFlights(String origin, String destination){
        boolean hasFlight = false;
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination) && flight.getNumberOfSeatsLeft() > 0){
                hasFlight = true;
                System.out.println("\nFlight Available: " + flight.toString());
            }
        }
        if(!hasFlight){
            System.out.println("No available flights or all booked");
        }
    }
    
    public Flight getFlight(int flightNumber){
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){ 
        for (Flight flight : flights) {
            if (flight.getFlightNumber()==flightNumber){ // flight number exists
                //System.out.println("flight exists");
                if (flight.getNumberOfSeatsLeft() > 0) {
                    //System.out.println("seats available");
                    flight.bookASeat();
                    //System.out.println("seat booked");
                    double ticketPrice = p.applyDiscount(flight.getOriginalPrice());
                    //System.out.println("ticket price determined");
                    Ticket issuedTicket = new Ticket(p, flight, ticketPrice);
                    //System.out.println("ticket issued.");
                    tickets.add(issuedTicket);
                    //System.out.println("ticket added to array list");
                    return;
                }                
                else{ //no more seats left
                    System.out.println("No more seats left on plane!");
                    return;
                }
            }
        }
        System.out.println("Sorry. Flight Number " + flightNumber + " does not exist.");
    } 
    
    public static void main(String[] args){
        
        Manager Airline = new Manager();        
        
        //hard-coded a array of large and visited cities
        String[] cities = new String[] {"Athens", "Amsterdam", "Bangalore", "Bangkok", "Baghdad", "Barcelona", "Beijing", "Berlin", 
            "Buenos Aires", "Cairo", "Cancun", "Chongqing", "Delhi", "Dhaka", "Dubai", "Guangzhou", "Hong Kong", "Hyderabad", 
            "Istanbul", "Jakarta", "Karachi", "Kolkata", "Kuala Lumpur", "Lahore", "Las Vegas", "Lima", "London", "Los Angeles", 
            "Macau", "Madrid", "Manila", "Mecca", "Mexico City", "Milan", "Miami", "Mumbai", "Montreal", "Moscow", "New York City", "Osaka", 
            "Paris", "Pune", "Riyadh", "Rio de Janeiro", "Rome", "Seoul", "Shanghai", "Sao Paulo", "Singapore", "St. Petersburg", 
            "Sydney", "Tehran", "Tokyo", "Toronto", "Tianjin", "Venice"};
        
        //automatically generating 100 different flights
        for (int i = 0; i < 99; i++) {            
            int randomFlightNumber = getRandIntBetween(1000, 9999); //randomly generate a 4-digit flight number
            int[] twoRandomCitiesIndexes =  getTwoRandIndexes();
                String randomOriginCity = cities[twoRandomCitiesIndexes[0]];
                String randomDestinationCity = cities[twoRandomCitiesIndexes[1]];            
            String randomDepartureTime = getRandomDepartureTime();
            int randomCapacity = getRandIntBetween(50, 400);
                int randomNumberOfSeatsBooked = getRandIntBetween(0, randomCapacity);
            double randomOriginalPrice = getRandIntBetween(500, 1500);
            
            Airline.createFlightsWithParam(randomFlightNumber, randomOriginCity, randomDestinationCity, randomDepartureTime, randomCapacity, randomNumberOfSeatsBooked, randomOriginalPrice);
        }        
        System.out.println("X has already created 100 flights. You will now be manually creating 1 new flight\n");
        Airline.createFlights();
        System.out.println("\n" + Airline.displayAllFlights()+"\nFinal Flight above ^ is the one you created!\n---------------------------\n---------------------------\n---------------------------");
        
        System.out.println("Testing displayAvailableFlights() method. Here is a list of cities the airline travels from and to:\n");
        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i]+ ((i==cities.length-1)?"":", ") ); //just output formatting
            if(i%10==0 && i!=0){
                System.out.print("\n"); //output formatting
            } 
        }      
        System.out.println("\n\nEnter which city are you coming from (origin): ");        
        Scanner sc = new Scanner(System.in);        
        String testOrigin = sc.nextLine();
        System.out.println("Enter which city are you going to (destination): ");
        String testDestination = sc.nextLine();        
        Airline.displayAvailableFlights(testOrigin, testDestination);        
        System.out.println("\n---------------------------\n---------------------------\n---------------------------");
        
        System.out.println("\nTesting getFlight() method. Enter a flight number: ");        
        int testFlightNumber;        
        while(true){
            try{
                testFlightNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Not an integer. try again: ");                
            }
        }        
        System.out.println(Airline.getFlight(testFlightNumber)+"\n---------------------------\n---------------------------\n---------------------------");

        
        Member john = new Member("John Smith", 45, 6);
        Member julia = new Member("Julia Chow", 30, 2);
        Member susan = new Member("Susan Boyle", 30, 1);
        NonMember ElonMusk = new NonMember("Elon Musk", 22);
        NonMember eugene = new NonMember("Eugene Krabs", 67);
        
        System.out.println("\nTesting bookSeat() method. 5 passenger instances have been hard-coded:");
        System.out.println(john.toString()); 
        System.out.println(julia.toString()); 
        System.out.println(susan.toString()); 
        System.out.println(ElonMusk.toString()); 
        System.out.println(eugene.toString());
        
        System.out.println("\nMost Flight Numbers are 4-digits for this airline. If we try to book a flight with a Flight Number that obviously doesn't exist (such as 42) for John, the program outputs...");
        Airline.bookSeat(42, john);
        
        System.out.println("Booking Flight Number " + Airline.getFlightNumberFromflightsIndex(1) + " (exists) for John.");
        System.out.println("Booking Flight Number " + Airline.getFlightNumberFromflightsIndex(2) + " (exists) for Julia.");
        System.out.println("Booking Flight Number " + Airline.getFlightNumberFromflightsIndex(3) + " (exists) for Susan.");
        System.out.println("Booking Flight Number " + Airline.getFlightNumberFromflightsIndex(4) + " (exists) for Elon.\n");
        
        
        Airline.bookSeat(Airline.getFlightNumberFromflightsIndex(1), john);
        Airline.bookSeat(Airline.getFlightNumberFromflightsIndex(2), julia);
        Airline.bookSeat(Airline.getFlightNumberFromflightsIndex(3), susan);
        Airline.bookSeat(Airline.getFlightNumberFromflightsIndex(4), ElonMusk);
        
        int flightNumberForEugene;
        System.out.println("Finally, you choose the flight Eugene Krabs will be taking with the corresponding Flight Number (scroll up to look back at the flight list): ");
        while(true){
            try{
                flightNumberForEugene = Integer.parseInt(sc.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Not an integer. try again: ");                
            }
        }
        Airline.bookSeat(flightNumberForEugene, eugene);
        
        System.out.println("\n" + Airline.displayAllTickets());
    }   
    
    
    
    /********* Utility Methods: Methods not asked for by lab instructions but helped me create a proper main method to be able to test the lab *********/
    public void createFlightsWithParam(int flightNumber, String originCity, String destinationCity, String departureTime, int capacity, int preBooked, double originalPrice) {        
        Flight flight = new Flight(flightNumber, originCity, destinationCity, departureTime, capacity, originalPrice);
        for (int i = 0; i < preBooked; i++) {
            flight.bookASeat();
        }
        flights.add(flight); 
    }
    
    public String displayAllFlights(){
        String allFlights="All Flights: \n";
        for (Flight flight : flights) {
            allFlights += flight.toString() + "\tcapacity: " + flight.getCapacity() + "\t# of seats left: " + flight.getNumberOfSeatsLeft() + "\n";            
        }
        return allFlights;
    }
    
    public String displayAllTickets(){
        String allTickets="All Tickets: \n";
        for (Ticket ticket : tickets) {
            allTickets += "Ticket #: " + ticket.getNumber() + "\t" + ticket.toString() + "\n";
        }
        return allTickets;
    }
    
    public int getFlightNumberFromflightsIndex(int index){
        return this.flights.get(index).getFlightNumber();
    }
    
    public static int[] getTwoRandIndexes(){
        Random rnd = new Random();        
        int[] twoRandsToReturn = new int[2];

        int randFirstCityElement = rnd.nextInt(40);
        int randSecondCityElement = rnd.nextInt(40);
        do {
            randSecondCityElement = rnd.nextInt(40);
        } while(randSecondCityElement == randFirstCityElement);

        twoRandsToReturn[0] = randFirstCityElement;
        twoRandsToReturn[1] = randSecondCityElement;

        return twoRandsToReturn;
    }
    
    public static int getRandIntBetween(int smallerNumber, int largerNumber) {
        Random rnd = new Random();
        return smallerNumber + rnd.nextInt(largerNumber - smallerNumber + 1); //random number from smallerNumber to largerNumber
    }
    
    public static double getRandDoubleBetween(double smallerNumber, double largerNumber) {
        Random rnd = new Random();
        return rnd.nextDouble()*(largerNumber-smallerNumber)+smallerNumber;
    }
    
    public static String getRandomDepartureTime(){        
        String randomDepTimeToReturn = "";
        
        Random rnd = new Random();
        int month = getRandIntBetween(1, 12); //random number from 1 to 12
        /* days in a month
        1  january:  31
        2  february: 28
        3  march:    31
        4  april:    30
        5  may:      31
        6  june      30
        7  july      31
        8  august    31
        9  september 30
        10 october   31
        11 november  30
        12 december  31 */
        int day;
        switch (month){
            case 1:
            case 3: 
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = getRandIntBetween(1, 31); //day between 1 and 31
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = getRandIntBetween(1, 30); ////day between 1 and 30
                break;
            case 2:
                day = getRandIntBetween(1, 28); //day between 1 and 28 (assuming no leap year)
                break;
            default:
                day = getRandIntBetween(1, 31);
        }
        
        int hour = getRandIntBetween(1, 12);
        int minute = getRandIntBetween(0, 59);
        String AMorPM = (rnd.nextInt(2)==1) ? "am" : "pm"; //selects am or pm
        
        randomDepTimeToReturn += ((day>=10)?"":"0") + day + "/" + ((month>=10)?"":"0") + month + "/" + "23" + " " + hour + ":" + ((minute>=10)?"":"0") + minute + " " + AMorPM;
        return randomDepTimeToReturn;
    }
    /*******************************************************************************************************************************************************************************/
}