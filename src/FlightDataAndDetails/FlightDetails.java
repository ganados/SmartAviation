package FlightDataAndDetails;

import Luggage.Baggage;
import Luggage.Cargo;

import java.util.LinkedList;
import java.util.List;

public class FlightDetails {
    private final int flightID;
    private final List<Baggage> flightBaggage;
    private final List<Cargo> flightCargo;

    public FlightDetails(int givenFlightID){
        this.flightID = givenFlightID;
        this.flightBaggage = new LinkedList<>();
        this.flightCargo = new LinkedList<>();
    }

    public int getFlightID(){
        return this.flightID;
    }

    public List<Baggage> getBaggage(){
        return this.flightBaggage;
    }

    public List<Cargo> getCargo(){
        return flightCargo;
    }

    public double getTotalWeightBaggage(String unit){
        double totalWeight = 0.0;
        for (Baggage baggage : getBaggage()){
            if(baggage.getBaggageWeightUnit().equals(unit))
                totalWeight += baggage.getBaggageWeight();
        }
        return totalWeight;
    }

    public double getTotalWeightCargo(String unit){
        double totalWeight = 0.0;
        for (Cargo cargo : getCargo()){
            if(cargo.getCargoWeightUnit().equals(unit))
                totalWeight += cargo.getCargoWeight();
        }
        return totalWeight;
    }

    public void getTotalWeight(){
        double totalWeightKg = getTotalWeightBaggage("kg") + getTotalWeightCargo("kg");
        double totalWeightLb = getTotalWeightBaggage("lb") + getTotalWeightCargo("lb");
        System.out.println("Total weight: " + totalWeightKg + "[kg] | " + totalWeightLb + "[lb]");
        System.out.println("Total weight: " + (totalWeightKg + (totalWeightLb * 0.45359237)) + "[kg]");
        System.out.println("Total weight: " + ((totalWeightKg * 2.20462262) + totalWeightLb) + "[lb]");

        totalWeightKg = getTotalWeightCargo("kg") + (getTotalWeightCargo("lb") *  0.45359237);
        totalWeightLb = (getTotalWeightCargo("kg") * 2.20462262) + getTotalWeightCargo("lb");
        System.out.println("\nCargo weight: " + getTotalWeightCargo("kg") + "[kg] | "
                + getTotalWeightCargo("lb") + "[lb]" + "\nTotal cargo weight: " + totalWeightKg + "[kg]"
                + "\nTotal cargo weight: " + totalWeightLb + "[lb]");

        totalWeightKg = getTotalWeightBaggage("kg") + (getTotalWeightBaggage("lb") *  0.45359237);
        totalWeightLb = (getTotalWeightBaggage("kg") * 2.20462262) + getTotalWeightBaggage("lb");
        System.out.println("\nBaggage weight: " + getTotalWeightBaggage("kg") + "[kg] | "
                + getTotalWeightBaggage("lb") + "[lb]" + "\nTotal baggage weight: " + totalWeightKg + "[kg]"
                + "\nTotal baggage weight: " + totalWeightLb + "[lb]");
    }

    public int getTotalPiecesBaggage(){
        int totalPieces = 0;
        for (Baggage baggage : getBaggage()){
            totalPieces += baggage.getBaggagePieces();
        }
        return totalPieces;
    }

    public void addBaggage(int givenID, int givenWeight, String givenUnit, int givenPieces){
        this.flightBaggage.add(new Baggage(givenID, givenWeight, givenUnit, givenPieces));
    }

    public void addCargo(int givenID, int givenWeight, String givenUnit, int givenPieces){
        this.flightCargo.add(new Cargo(givenID, givenWeight, givenUnit, givenPieces));
    }
}
