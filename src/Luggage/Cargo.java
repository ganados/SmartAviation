package Luggage;

public class Cargo {
    private final int cargoID;
    private final int cargoWeight;
    private final String cargoWeightUnit;
    private final int cargoPieces;

    public Cargo(int givenID, int givenWeight, String givenUnit, int givenPieces){
        this.cargoID = givenID;
        this.cargoWeight = givenWeight;
        this.cargoWeightUnit = givenUnit;
        this.cargoPieces = givenPieces;
    }

    public int getCargoID(){
        return this.cargoID;
    }
    public int getCargoWeight(){
        return this.cargoWeight;
    }
    public String getCargoWeightUnit(){
        return this.cargoWeightUnit;
    }
    public int getCargoPieces(){
        return this.cargoPieces;
    }
}
