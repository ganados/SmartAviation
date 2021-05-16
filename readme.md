### Task:
    Your task is to implement application with two functionalities :
    1. For requested Flight Number and date will respond with following :
       a. Cargo Weight for requested Flight
       b. Baggage Weight for requested Flight
       c. Total Weight for requested Flight
    2. For requested IATA Airport Code and date will respond with following :
       a. Number of flights departing from this airport,
       b. Number of flights arriving to this airport,
       c. Total number (pieces) of baggage arriving to this airport,
       d. Total number (pieces) of baggage departing from this airport.
### For test, I used:
Task\Data | Flight number / Airport code | Date|
---- | ---------- | -------------------------- |
First Task | 8776 | 2014-06-03T12:40:19-02:00  |
    |      |3430  |  2020-10-04T01:57:09-02:00 |
Second Task| YYZ  | 2016-12-15T12:44:10-01:00  |
        |  | PPX  | 2014-07-14T02:44:27-02:00  |
    

### Generated data:
#### Flight Entity
    [
    {
    "flightId": 0,
    "flightNumber": 9079,
    "departureAirportIATACode": "YYZ",
    "arrivalAirportIATACode": "LEW",
    "departureDate": "2016-12-15T12:44:10-01:00"
    },
    {
    "flightId": 1,
    "flightNumber": 8776,
    "departureAirportIATACode": "LAX",
    "arrivalAirportIATACode": "PPX",
    "departureDate": "2014-06-03T12:40:19-02:00"
    },
    {
    "flightId": 2,
    "flightNumber": 3430,
    "departureAirportIATACode": "YYZ",
    "arrivalAirportIATACode": "PPX",
    "departureDate": "2020-10-04T01:57:09-02:00"
    },
    {
    "flightId": 3,
    "flightNumber": 7717,
    "departureAirportIATACode": "YYZ",
    "arrivalAirportIATACode": "KRK",
    "departureDate": "2020-12-22T05:46:57-01:00"
    },
    {
    "flightId": 4,
    "flightNumber": 6369,
    "departureAirportIATACode": "YYZ",
    "arrivalAirportIATACode": "PPX",
    "departureDate": "2014-07-14T02:44:27-02:00"
    }
    ]
#### Cargo Entity
        [
    {
    "flightId": 0,
    "baggage": [
    {
    "id": 0,
    "weight": 310,
    "weightUnit": "kg",
    "pieces": 257
    },
    {
    "id": 1,
    "weight": 835,
    "weightUnit": "kg",
    "pieces": 171
    },
    {
    "id": 2,
    "weight": 386,
    "weightUnit": "kg",
    "pieces": 193
    },
    {
    "id": 3,
    "weight": 986,
    "weightUnit": "kg",
    "pieces": 777
    }
    ],
    "cargo": [
    {
    "id": 0,
    "weight": 275,
    "weightUnit": "lb",
    "pieces": 173
    },
    {
    "id": 1,
    "weight": 626,
    "weightUnit": "kg",
    "pieces": 284
    },
    {
    "id": 2,
    "weight": 806,
    "weightUnit": "kg",
    "pieces": 502
    },
    {
    "id": 3,
    "weight": 10,
    "weightUnit": "lb",
    "pieces": 202
    }
    ]
    },
    {
    "flightId": 1,
    "baggage": [
    {
    "id": 0,
    "weight": 603,
    "weightUnit": "kg",
    "pieces": 209
    },
    {
    "id": 1,
    "weight": 870,
    "weightUnit": "lb",
    "pieces": 172
    },
    {
    "id": 2,
    "weight": 627,
    "weightUnit": "kg",
    "pieces": 982
    },
    {
    "id": 3,
    "weight": 179,
    "weightUnit": "kg",
    "pieces": 437
    },
    {
    "id": 4,
    "weight": 90,
    "weightUnit": "lb",
    "pieces": 836
    }
    ],
    "cargo": [
    {
    "id": 0,
    "weight": 897,
    "weightUnit": "kg",
    "pieces": 18
    },
    {
    "id": 1,
    "weight": 825,
    "weightUnit": "lb",
    "pieces": 510
    },
    {
    "id": 2,
    "weight": 874,
    "weightUnit": "kg",
    "pieces": 445
    },
    {
    "id": 3,
    "weight": 511,
    "weightUnit": "kg",
    "pieces": 343
    },
    {
    "id": 4,
    "weight": 816,
    "weightUnit": "kg",
    "pieces": 310
    }
    ]
    },
    {
    "flightId": 2,
    "baggage": [
    {
    "id": 0,
    "weight": 889,
    "weightUnit": "lb",
    "pieces": 829
    },
    {
    "id": 1,
    "weight": 484,
    "weightUnit": "kg",
    "pieces": 793
    },
    {
    "id": 2,
    "weight": 834,
    "weightUnit": "lb",
    "pieces": 304
    },
    {
    "id": 3,
    "weight": 500,
    "weightUnit": "kg",
    "pieces": 175
    },
    {
    "id": 4,
    "weight": 449,
    "weightUnit": "kg",
    "pieces": 647
    },
    {
    "id": 5,
    "weight": 251,
    "weightUnit": "kg",
    "pieces": 512
    },
    {
    "id": 6,
    "weight": 372,
    "weightUnit": "kg",
    "pieces": 292
    }
    ],
    "cargo": [
    {
    "id": 0,
    "weight": 87,
    "weightUnit": "lb",
    "pieces": 615
    },
    {
    "id": 1,
    "weight": 824,
    "weightUnit": "kg",
    "pieces": 468
    },
    {
    "id": 2,
    "weight": 585,
    "weightUnit": "kg",
    "pieces": 639
    },
    {
    "id": 3,
    "weight": 551,
    "weightUnit": "lb",
    "pieces": 809
    },
    {
    "id": 4,
    "weight": 226,
    "weightUnit": "kg",
    "pieces": 601
    }
    ]
    },
    {
    "flightId": 3,
    "baggage": [
    {
    "id": 0,
    "weight": 810,
    "weightUnit": "kg",
    "pieces": 373
    },
    {
    "id": 1,
    "weight": 961,
    "weightUnit": "lb",
    "pieces": 533
    },
    {
    "id": 2,
    "weight": 658,
    "weightUnit": "kg",
    "pieces": 198
    },
    {
    "id": 3,
    "weight": 158,
    "weightUnit": "kg",
    "pieces": 518
    },
    {
    "id": 4,
    "weight": 821,
    "weightUnit": "lb",
    "pieces": 293
    },
    {
    "id": 5,
    "weight": 473,
    "weightUnit": "kg",
    "pieces": 805
    }
    ],
    "cargo": [
    {
    "id": 0,
    "weight": 621,
    "weightUnit": "kg",
    "pieces": 706
    },
    {
    "id": 1,
    "weight": 368,
    "weightUnit": "lb",
    "pieces": 959
    },
    {
    "id": 2,
    "weight": 768,
    "weightUnit": "lb",
    "pieces": 854
    },
    {
    "id": 3,
    "weight": 241,
    "weightUnit": "kg",
    "pieces": 34
    },
    {
    "id": 4,
    "weight": 796,
    "weightUnit": "lb",
    "pieces": 884
    }
    ]
    },
    {
    "flightId": 4,
    "baggage": [
    {
    "id": 0,
    "weight": 893,
    "weightUnit": "lb",
    "pieces": 961
    },
    {
    "id": 1,
    "weight": 388,
    "weightUnit": "lb",
    "pieces": 49
    },
    {
    "id": 2,
    "weight": 409,
    "weightUnit": "lb",
    "pieces": 732
    }
    ],
    "cargo": [
    {
    "id": 0,
    "weight": 99,
    "weightUnit": "lb",
    "pieces": 452
    },
    {
    "id": 1,
    "weight": 914,
    "weightUnit": "lb",
    "pieces": 327
    },
    {
    "id": 2,
    "weight": 981,
    "weightUnit": "kg",
    "pieces": 19
    },
    {
    "id": 3,
    "weight": 551,
    "weightUnit": "lb",
    "pieces": 680
    },
    {
    "id": 4,
    "weight": 166,
    "weightUnit": "kg",
    "pieces": 324
    }
    ]
    }
    ]

### A short description of several functions
-     public int getTotalPieces(List<Integer> flightIdList, String date)  
  getTotalPieces calculates a total number of baggage, for all flightId in flightIdList


-     public void getCargoBaggageTotalWeight(int flightNumber, String date)  
  Function after found needed flightID starts another function which will calc requested total weight
  of baggage and cargo ([lbs] and [kg])
  

-     private static StringBuilder getFlightCodesDate(String filePath)  
  Reading from JSON file, line by line to get specified information about flights


-     static FlightData[] createNewFlightsData()  
  Creating an array of FlightData objects which contains information about IATA departure and arrival codes
  Flight id, departure date and flight number.


-     static FlightDetails [] createNewFlightsDetails()  
  Creating an array of FlightDetails objects which contains details of each flight such as information about baggage,
  cargo, their weight and pieces, it contains flight id too.


-     private static Map<String, List<Integer>> getCountOfArrivalFlights(FlightData[] flightData, String code)  
  Collectors to easily get map which contains key: ArrivalCode, value: List of flightID,
it will help to get count of flights departing/arriving from requested Airport (by IATA code).
