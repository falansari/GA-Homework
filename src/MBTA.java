import java.util.*;

/*
- RED LINE:
    South Station
    Park Street
    Kendall
    Central
    Harvard
    Porter
    Davis
    Alewife

- GREEN LINE:
    Government Center
    Park Street
    Boylston
    Arlington
    Copley
    Hynes
    Kenmore

- ORANGE LINE:
    North Station
    Haymarket
    Park Street
    State
    Downtown Crossing
    Chinatown
    Back Bay
    Forest Hills

 */
public class MBTA {
    public static HashMap<String, String[]> lines = new HashMap<>();
    public static LinkedList<String> travelledStations = new LinkedList<>();

    public static void main(String[] args) {
        lines.put("red", new String[]{"south station", "park street", "kendall",
        "central", "harvard", "porter", "davis", "alewife"});
        lines.put("green", new String[]{"government center", "park street",
        "boylston", "arlington", "copley", "hynes", "kenmore"});
        lines.put("orange", new String[]{"north station", "haymarket",
        "park street", "state", "downtown crossing", "chinatown", "back bay",
        "forest hills"});

        int journey1 = stopsBetweenStations("green", "kenmore","red", "harvard");
        System.out.println("Number of stops for the ride: " + journey1);
        System.out.println(" ");
        /*int journey2 = stopsBetweenStations("red", "davis","red", "south station");
        System.out.println("Number of stops for the ride: " + journey2);*/
    }

    public static int stopsBetweenStations(String startLine, String startStation, String endLine, String endStation) {
        String[] startLineStations = lines.get(startLine);
        String[] endLineStations = lines.get(endLine);
        int indexStartStation = Arrays.asList(startLineStations).indexOf(startStation);
        int indexEndStation = Arrays.asList(endLineStations).indexOf(endStation);
        String currentStation = startStation;
        int travelDistance;

        /* LOGIC FLOW
        1. Check start and end lines are the same.
            a. If true (one line):
                1. Check start station index is smaller than end station index:
                    a. If true:
                        - Move forward through stations until end station (i++)
                    b. If false:
                        - Move backwards through stations until end station (i--)
            b. If false (two lines):
                1. Travel through line 1:
                    1. Set current station to start station.
                    2. Check current station is not park street:
                        a. If true (not park street):
                            1. Check start station index is smaller than end station index:
                                a. Is true (smaller):
                                    - Set loop direction to positive
                                    loop condition: int _i = indexStartStation + 1; _i < startLineStations.length; _i++
                                    - Move forward through stations until end station (i++)
                                b. Is false (larger):
                                    - Set loop direction to negative
                                    loop condition: int _i = indexStartStation - 1; _i >= 0; _i--
                        b. If false (is park street):
                            1. Set park street crossed to true
                            2. Set current station to park street
                            3. End line 1 travel (break)
                2. Travel through line 2:
                    1. Check park street crossed:
                        a. Is True (park street crossed):
                            1. Set park street index from line 2.
                            2. Check start station index (park street) is smaller than end station index:
                                a. Is true (smaller):
                                    - Set loop direction to positive
                                    loop condition: int _i = indexParkStreet + 1; _i < endLineStations.length; _i++
                                    - Move forward through stations until end station (i++)
                                b. Is false (larger):
                                    - Set loop direction to negative
                                    loop condition: int _i = indexParkStreet - 1; _i >= 0; _i--
                        b. Is False (park street not crossed):
                            1. Check start station index is smaller than end station index:
                                a. Is true (smaller):
                                    - Set loop direction to positive
                                    loop condition: int _i = indexEndStation + 1; _i < endLineStations.length; _i++
                                    - Move forward through stations until end station (i++)
                                b. Is false (larger):
                                    - Set loop direction to negative
                                    loop condition: int _i = indexEndStation - 1; _i >= 0; _i--
         */
/*
        //1. Check start and end lines are the same.
        if (isSameString(startLine, endLine)) {
            //            a. If true (one line):
            //                1. Check start station index is smaller than end station index:
            if (!isLargerInt(indexStartStation, indexEndStation)) {
                //                    a. If true:
                //                        - Move forward through stations until end station (i++)
            } else {
                //                    b. If false:
                //                        - Move backwards through stations until end station (i--)
            }
        } else {
            // b. If false (two lines):
            //                1. Travel through line 1:
            //                    1. Set current station to start station.
            currentStation = startStation;
            //                    2. Check current station is not park street:
            if (!isSameString(currentStation, "park street")) {
                //                        a. If true (not park street):
                //                            1. Check start station index is smaller than end station index:
                if (!isLargerInt(indexStartStation, indexEndStation)) {
                    //                                a. Is true (smaller):
                    //                                    - Set loop direction to positive
                    //                                    loop condition: int _i = indexStartStation + 1; _i < startLineStations.length; _i++
                    //                                    - Move forward through stations until end station (i++)
                } else {
                    //                                b. Is false (larger):
                    //                                    - Set loop direction to negative
                    //                                    loop condition: int _i = indexStartStation - 1; _i >= 0; _i--
                }
            } else {
                //                        b. If false (is park street):
                //                            1. Set park street crossed to true

                //                            2. Set current station to park street
                //                            3. End line 1 travel (break)
                //                2. Travel through line 2:
                //                    1. Check park street crossed:
                //                        a. Is True (park street crossed):
                //                            1. Set park street index from line 2.
                //                            2. Check start station index (park street) is smaller than end station index:
                //                                a. Is true (smaller):
                //                                    - Set loop direction to positive
                //                                    loop condition: int _i = indexParkStreet + 1; _i < endLineStations.length; _i++
                //                                    - Move forward through stations until end station (i++)
                //                                b. Is false (larger):
                //                                    - Set loop direction to negative
                //                                    loop condition: int _i = indexParkStreet - 1; _i >= 0; _i--
                //                        b. Is False (park street not crossed):
                //                            1. Check start station index is smaller than end station index:
                //                                a. Is true (smaller):
                //                                    - Set loop direction to positive
                //                                    loop condition: int _i = indexEndStation + 1; _i < endLineStations.length; _i++
                //                                    - Move forward through stations until end station (i++)
                //                                b. Is false (larger):
                //                                    - Set loop direction to negative
                //                                    loop condition: int _i = indexEndStation - 1; _i >= 0; _i--
            }
        }
*/
/*
        // Iterate start line, skip the first station
        if (isSameString(startLine, endLine)) { // Travel through 1 line
            // start station index is smaller than end station index
            //if (!isLargerInt(indexStartStation, indexEndStation)) {
                for (int _i = indexStartStation + 1; _i < startLineStations.length; _i++) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            } else { // Start station index is larger than end station index
                for (int _i = indexStartStation - 1; _i >= 0; _i--) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            //}
        } else { // Travel through 2 lines
            boolean isParkStreetCrossed = false;

            // Iterate line 1 until park street
            if (indexStartStation < indexEndStation) { // start station index is smaller than end station index
                for (int _i = indexStartStation + 1; _i < startLineStations.length; _i++) {
                    if (!Objects.equals(currentStation, endStation)) {
                        if (Objects.equals(currentStation, "park street")) {
                            isParkStreetCrossed = true;
                            break;
                        }
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            } else { // Start station index is larger than end station index
                for (int _i = indexStartStation - 1; _i >= 0; _i--) {
                    if (!Objects.equals(currentStation, endStation)) {
                        if (isSameString(currentStation, "park street")) {
                            isParkStreetCrossed = true;
                            break;
                        }
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            }

            int indexParkStreet = Arrays.asList(endLineStations).indexOf("park street");

            if (isParkStreetCrossed) {
                // Iterate line 2 from park street until end station
                //if (indexStartStation < indexEndStation) { // start station index is smaller than end station index
                    for (int _i = indexParkStreet + 1; _i < endLineStations.length; _i++) {
                        if (!Objects.equals(currentStation, endStation)) {
                            currentStation = endLineStations[_i];
                            travelStation(currentStation);
                            System.out.println("Current station: " + currentStation);
                        }
                    }
                } else { // start station index is larger than end station index
                    for (int _i = indexStartStation - 1; _i >= 0; _i--) {
                        if (!isSameString(currentStation, endStation)) {
                            currentStation = startLineStations[_i];
                            travelStation(currentStation);
                            System.out.println("Current station: " + currentStation);
                        }
                    }
                }
            } else { // Park street not crossed on line 1
                // Iterate line 2 from park street until end station
                for (int _i = 0; _i < endLineStations.length; _i++) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = endLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            }
        }
*/

        // FINAL: no reverse travel only forwards except on 1 line
        // Iterate start line, skip the first station
        if (isSameString(startLine, endLine)) { // Travel through 1 line
            // start station index is smaller than end station index
            if (!isLargerInt(indexStartStation, indexEndStation)) {
                for (int _i = indexStartStation + 1; _i < startLineStations.length; _i++) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            } else { // Start station index is larger than end station index
                for (int _i = indexStartStation - 1; _i >= 0; _i--) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            }
        } else { // Travel through 2 lines
            boolean isParkStreetCrossed = false;

            // Iterate line 1 until park street
            if (indexStartStation < indexEndStation) { // start station index is smaller than end station index
                for (int _i = indexStartStation + 1; _i < startLineStations.length; _i++) {
                    if (!Objects.equals(currentStation, endStation)) {
                        if (Objects.equals(currentStation, "park street")) {
                            isParkStreetCrossed = true;
                            break;
                        }
                        currentStation = startLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            }

            int indexParkStreet = Arrays.asList(endLineStations).indexOf("park street");

            if (isParkStreetCrossed) {
                // Iterate line 2 from park street until end station
                for (int _i = indexParkStreet + 1; _i < endLineStations.length; _i++) {
                    if (!Objects.equals(currentStation, endStation)) {
                        currentStation = endLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            } else { // Park street not crossed on line 1
                // Iterate line 2 from park street until end station
                for (int _i = 0; _i < endLineStations.length; _i++) {
                    if (!isSameString(currentStation, endStation)) {
                        currentStation = endLineStations[_i];
                        travelStation(currentStation);
                        System.out.println("Current station: " + currentStation);
                    }
                }
            }
        }

        travelDistance = travelledStations.size();
        System.out.println("Stations crossed: " + travelledStations);

        return travelDistance;
    }

    protected static void travelStation(String station) {
        travelledStations.add(station);
    }

    protected static boolean isSameString(String string1, String string2) {
        return Objects.equals(string1, string2);
    }

    /**
     * Check if the first number is larger than the second number.
     * @param number1
     * @param number2
     * @return true/false
     */
    protected static boolean isLargerInt(int number1, int number2) {
        return number1 > number2;
    }
}
