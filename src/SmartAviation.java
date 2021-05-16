import DataService.DataService;

public class SmartAviation {
    public static void main(String[] args){
        DataService dataService = new DataService();

        System.out.println("\nI");
        System.out.println("Cargo, baggage and total weight for requested flight number and date: ");
        dataService.getCargoBaggageTotalWeight(8776, "2014-06-03T12:40:19-02:00");

        System.out.println("\nNumber of flights (arrival and departure) and total pieces of baggage "+
                            "for requested Airport IATA code and date: ");
        dataService.getBaggageTotalPieces("YYZ", "2016-12-15T12:44:10-01:00");

        System.out.println("\nII");
        System.out.println("Cargo, baggage and total weight for requested flight number and date: ");
        dataService.getCargoBaggageTotalWeight(3430, "2020-10-04T01:57:09-02:00");

        System.out.println("\nNumber of flights (arrival and departure) and total pieces of baggage "+
                "for requested Airport IATA code and date: ");
        dataService.getBaggageTotalPieces("PPX", "2014-07-14T02:44:27-02:00");

    }
}
