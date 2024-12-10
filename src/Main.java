import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusSchedule schedule = new BusSchedule();

        while (true) {
            System.out.println("1. Добавить маршрут");
            System.out.println("2. Удалить маршрут");
            System.out.println("3. Поиск маршрутов");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите номер рейса: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Введите маршрут: ");
                    String route = scanner.nextLine();
                    System.out.print("Введите промежуточные остановки (через запятую): ");
                    List<String> stops = Arrays.asList(scanner.nextLine().split(","));
                    System.out.print("Введите время отправления: ");
                    String departureTime = scanner.nextLine();
                    System.out.print("Введите дни отправления (через запятую): ");
                    List<String> days = Arrays.asList(scanner.nextLine().split(","));
                    System.out.print("Введите количество свободных мест: ");
                    int availableSeats = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера

                    schedule.addRoute(new BusRoute(flightNumber, route, stops, departureTime, days, availableSeats));
                    break;

                case 2:
                    System.out.print("Введите номер рейса для удаления: ");
                    String flightToDelete = scanner.nextLine();
                    schedule.deleteRoute(flightToDelete);
                    break;

                case 3:
                    System.out.print("Введите параметр для поиска: ");
                    String query = scanner.nextLine();
                    List<BusRoute> results = schedule.search(query);
                    for (BusRoute r : results) {
                        System.out.println(r);
                    }
                    break;

                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}