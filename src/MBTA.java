import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public static void main(String[] args) {
        lines.put("red", new String[]{"south station", "park street", "kendall",
        "central", "harvard", "porter", "davis", "alewife"});
        lines.put("green", new String[]{"government center", "park street",
        "boylston", "arlington", "copley", "hynes", "kenmore"});
        lines.put("orange", new String[]{"north station", "haymarket",
        "park street", "state", "downtown crossing", "chinatown", "back bay",
        "forest hills"});

        //System.out.println(Arrays.toString(lines.get("red")));
        //System.out.println(Arrays.toString(lines.get("green")));
        //System.out.println(Arrays.toString(lines.get("orange")));

        int stops = stopsBetweenStations("red", "harvard",
                "orange", "downtown crossing");
        System.out.println("Number of stops for the ride: " + stops);
        /*int stops2 = stopsBetweenStations("red", "harvard",
                "red", "alewife");
        System.out.println("Number of stops for the ride: " + stops2);*/
    }

    public static int stopsBetweenStations(String startLine, String startStation, String endLine, String endStation) {
        String[] startStations = lines.get(startLine);
        int startStationIndex = Arrays.binarySearch(startStations, startStation);

        String[] endStations = lines.get(endLine);
        int endStationIndex = Arrays.binarySearch(endStations, endStation);

        String currentStation = startStation;
        int travelDistance = 0;
        int result = 0;

        for (int _i = startStationIndex + 1; _i < startStations.length; _i++) {
            if (!Objects.equals(currentStation, endStation)) {
                travelDistance++;
                currentStation = startStations[_i];
                System.out.println("Current station: " + currentStation);
            }
        }
        System.out.println("Travel distance: " + travelDistance);

        if (!Objects.equals(startLine, endLine)) {
            for (int _i = 0; _i < endStations.length; _i++) {
                if (!Objects.equals(currentStation, endStation)) {
                    travelDistance++;
                    currentStation = endStations[_i];
                    System.out.println("Current station: " + currentStation);
                }
            }
        }
        System.out.println("Travel distance: " + travelDistance);

        return travelDistance;
    }
}
