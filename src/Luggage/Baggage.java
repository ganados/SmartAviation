package Luggage;

public class Baggage {
    private final int baggageID;
    private final int baggageWeight;
    private final String baggageWeightUnit;
    private final int baggagePieces;

    public Baggage(int givenID, int givenWeight, String givenUnit, int givenPieces){
        this.baggageID = givenID;
        this.baggageWeight = givenWeight;
        this.baggageWeightUnit = givenUnit;
        this.baggagePieces = givenPieces;
    }

    public int getBaggageID(){
        return this.baggageID;
    }
    public int getBaggageWeight(){
        return this.baggageWeight;
    }
    public String getBaggageWeightUnit(){
        return this.baggageWeightUnit;
    }
    public int getBaggagePieces(){
        return this.baggagePieces;
    }
}
