import java.io.*;
import java.util.*;

public class BusSchedule {
    private static final String FILE_NAME = "bus_schedule.txt";
    private List<BusRoute> routes;

    public BusSchedule() {
        routes = new ArrayList<>();
        loadRoutes();
    }

    private void loadRoutes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String flightNumber = parts[0];
                String route = parts[1];
                List<String> intermediateStops = Arrays.asList(parts[2].split(","));
                String departureTime = parts[3];
                List<String> departureDays = Arrays.asList(parts[4].split(","));
                int availableSeats = Integer.parseInt(parts[5]);
                routes.add(new BusRoute(flightNumber, route, intermediateStops, departureTime, departureDays, availableSeats));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке маршрутов: " + e.getMessage());
        }
    }

    public void addRoute(BusRoute route) {
        routes.add(route);
        saveRoutes();
    }

    private void saveRoutes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (BusRoute route : routes) {
                bw.write(route.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении маршрутов: " + e.getMessage());
        }
    }

    public void deleteRoute(String flightNumber) {
        routes.removeIf(route -> route.flightNumber.equals(flightNumber));
        saveRoutes();
    }

    public List<BusRoute> search(String query) {
        List<BusRoute> result = new ArrayList<>();
        for (BusRoute route : routes) {
            if (route.flightNumber.contains(query) || route.route.contains(query)) {
                result.add(route);
            }
        }
        return result;
    }
}