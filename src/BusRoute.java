import java.util.*;

public class BusRoute {
    String flightNumber;
    String route;
    List<String> intermediateStops;
    String departureTime;
    List<String> departureDays;
    int availableSeats;

    public BusRoute(String flightNumber, String route, List<String> intermediateStops, String departureTime, List<String> departureDays, int availableSeats) {
        this.flightNumber = flightNumber;
        this.route = route;
        this.intermediateStops = intermediateStops;
        this.departureTime = departureTime;
        this.departureDays = departureDays;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return flightNumber + ";" + route + ";" + String.join(",", intermediateStops) + ";" + departureTime + ";" + String.join(",", departureDays) + ";" + availableSeats;
    }
}