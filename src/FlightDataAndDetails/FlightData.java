package FlightDataAndDetails;


public class FlightData {
    private final int flightID;
    private final int flightNumber;
    private final String departureCode;
    private final String arrivalCode;
    private final String depDate;

    public FlightData(int givenID, int givenFlightNumber, String givenDeparture, String givenArrival, String givenDate){
        this.flightID = givenID;
        this.flightNumber = givenFlightNumber;
        this.depDate = givenDate;
        this.arrivalCode = givenArrival;
        this.departureCode = givenDeparture;
    }
    public int getFlightID(){
        return this.flightID;
    }
    public int getFlightNumber(){
        return this.flightNumber;
    }
    public String getDepartureCode(){
        return this.departureCode;
    }
    public String getArrivalCode(){
        return this.arrivalCode;
    }
    public String getFlightDate(){
        return this.depDate;
    }

}
