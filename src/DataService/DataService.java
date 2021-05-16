package DataService;

import FlightDataAndDetails.FlightDetails;
import FlightDataAndDetails.FlightData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class DataService {

    private final FlightData[] flightData;
    private final FlightDetails[] flightDetails;



    public DataService(){
        this.flightDetails = createNewFlightsDetails();
        this.flightData = createNewFlightsData();
    }
    public FlightDetails[] getFlightDetails(){
        return this.flightDetails;
    }

    public FlightData[] getFlightData(){
        return this.flightData;
    }

    public void getBaggageTotalPieces(String airportCode, String date){
        int arrivals, departures, arrivalsPieces, departuresPieces;
        Map<String, List<Integer>> arrivalsMap = getCountOfArrivalFlights(getFlightData(), airportCode);
        Map<String, List<Integer>> departuresMap = getCountOfDepartureFlights(getFlightData(), airportCode);
        try{
            arrivals = arrivalsMap.get(airportCode).size();
        }
        catch (NullPointerException e){
            arrivals = 0;
        }
        try{
            arrivalsPieces = getTotalPieces(arrivalsMap.get(airportCode), date);
        }
        catch (NullPointerException e){
            arrivalsPieces = 0;
        }
        try {
            departures = departuresMap.get(airportCode).size();

        }
        catch (NullPointerException e){
            departures = 0;
        }
        try{
            departuresPieces = getTotalPieces(departuresMap.get(airportCode), date);
        }
        catch (NullPointerException e){
            departuresPieces = 0;
        }

        System.out.println("Flights departing from " + airportCode + " Airport: "
                + departures + "\nTotal pieces: " + departuresPieces
                + "\n\nFlights arriving to " + airportCode + " Airport: "
                + arrivals + "\nTotal pieces: " + arrivalsPieces);

    }

    public int getTotalPieces(List<Integer> flightIdList, String date){
        int pieces = 0;
        for (FlightDetails flightDetails : getFlightDetails()){
            if(flightIdList.contains(flightDetails.getFlightID())){
                for(FlightData flightData : getFlightData()) {
                    if (parseDate(date).isEqual(parseDate(flightData.getFlightDate())) && flightIdList.contains(flightData.getFlightID())) {
                        pieces += flightDetails.getTotalPiecesBaggage();
                    }
                }
            }
        }
        return pieces;
    }

    public ZonedDateTime parseDate(String date){
        return ZonedDateTime.parse(date);
    }

    public void getCargoBaggageTotalWeight(int flightNumber, String date){
        int flightId = -1;
        for(FlightData flightData : getFlightData()){
            if(flightData.getFlightNumber() == flightNumber && parseDate(flightData.getFlightDate()).isEqual(parseDate(date))){
                flightId = flightData.getFlightID();
                break;
            }
        }
        if(flightId == -1)
            throw new NoSuchElementException("There is no flight with this number");

        for(FlightDetails flightDetails : getFlightDetails()){
            if(flightDetails.getFlightID() == flightId){
                flightDetails.getTotalWeight();
            }
        }
    }

    private static StringBuilder getFlightCodesDate(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while (true) {
            try {
                if (bufferedReader != null && ((line = bufferedReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }

    static FlightData[] createNewFlightsData(){
        StringBuilder stringBuilder = getFlightCodesDate("src/data.json");
        JSONArray information = new JSONArray(stringBuilder.toString());
        FlightData[] flightData = new FlightData[information.length()];

        for (int i = 0; i < information.length(); i++){
            JSONObject obj = information.getJSONObject(i);

            int flightID = obj.getInt("flightId");
            int flightNumber = obj.getInt("flightNumber");
            String depCode = obj.getString("departureAirportIATACode");
            String arrCode = obj.getString("arrivalAirportIATACode");
            String depDate = obj.getString("departureDate");

            flightData[i] = new FlightData(flightID, flightNumber, depCode, arrCode, depDate);
        }
        return flightData;
    }

    static FlightDetails [] createNewFlightsDetails(){
        StringBuilder stringBuilder = getFlightCodesDate("src/weight.json");
        JSONArray information = new JSONArray(stringBuilder.toString());

        FlightDetails[] flightDetails = new FlightDetails[information.length()];


        for(int i = 0; i < information.length(); i++){
            JSONObject obj = information.getJSONObject(i);
            int flightID = obj.getInt("flightId");

            JSONArray innerBaggage = obj.getJSONArray("baggage");
            JSONArray innerCargo = obj.getJSONArray("cargo");
            flightDetails[i] = new FlightDetails(flightID);

            for(int j = 0; j < innerBaggage.length(); j++){
                JSONObject innerObj = innerBaggage.getJSONObject(j);

                int baggageID = innerObj.getInt("id");
                int baggageWeight = innerObj.getInt("weight");
                String baggageUnit = innerObj.getString("weightUnit");
                int baggagePieces = innerObj.getInt("pieces");

                flightDetails[i].addBaggage(baggageID, baggageWeight, baggageUnit, baggagePieces);
            }

            for(int j = 0; j < innerCargo.length(); j++){
                JSONObject innerObj = innerCargo.getJSONObject(j);

                int baggageID = innerObj.getInt("id");
                int baggageWeight = innerObj.getInt("weight");
                String baggageUnit = innerObj.getString("weightUnit");
                int baggagePieces = innerObj.getInt("pieces");
                flightDetails[i].addCargo(baggageID, baggageWeight, baggageUnit, baggagePieces);
            }
        }
        return flightDetails;
    }

    private static Map<String, List<Integer>> getCountOfArrivalFlights(FlightData[] flightData, String code) {
        return Arrays.stream(flightData)
                .filter(flight -> flight.getArrivalCode().equals(code))
                .collect(Collectors.groupingBy(FlightData::getArrivalCode, Collectors.mapping(FlightData::getFlightID, Collectors.toList())));
    }

    private static Map<String, List<Integer>> getCountOfDepartureFlights(FlightData[] flightData, String code) {
        return Arrays.stream(flightData)
                .filter(flight -> flight.getDepartureCode().equals(code))
                .collect(Collectors.groupingBy(FlightData::getDepartureCode, Collectors.mapping(FlightData::getFlightID, Collectors.toList())));
    }
}
