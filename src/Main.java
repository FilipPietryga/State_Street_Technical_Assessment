import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<CarType, Integer> availableCars = Map.of(
            CarType.SEDAN, 5,
            CarType.SUV, 3,
            CarType.VAN, 4
    );

    private static final CarReservationService carReservationService = new CarReservationService(availableCars);

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Starting Simplified Car Reservation Service...");

        boolean run = true;
        while(run) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    reserveCar();
                    break;
                case "2":
                    System.out.println("Exiting application. Thank you!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n--- Simplified Car Reservation System ---");
        System.out.println("1. Reserve a car");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void reserveCar() {
        System.out.println("\n--- Make a Reservation ---");

        CarType carType = null;
        String dateTimeInput = null;
        int days = -1;

        while (carType == null) {
            System.out.print("Enter the car type (Sedan, SUV, Van): ");
            String typeInput = scanner.nextLine();
            String cleanedInput = typeInput.trim().toUpperCase();
            try {
                carType = CarType.valueOf(cleanedInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid car type. Please enter a valid type (e.g., Sedan).");
            }
        }

        while (dateTimeInput == null) {
            System.out.print("Enter the reservation date and time (YYYY-MM-DD HH:MM): ");
            dateTimeInput = scanner.nextLine();
            try {
                LocalDateTime.parse(dateTimeInput.replace(" ", "T"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date and time format. Please use YYYY-MM-DD HH:MM.");
                dateTimeInput = null;
            }
        }

        while (days < 0) {
            System.out.print("Enter number of days for the reservation: ");
            String daysInput = scanner.nextLine();
            try {
                days = Integer.parseInt(daysInput);
                if (days < 1) {
                    System.out.println("Number of days must be at least 1.");
                    days = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of days. Please enter a number.");
                days = -1;
            }
        }

        LocalDateTime reservationDateTime = LocalDateTime.parse(dateTimeInput.replace(" ", "T"));
        CarReservation reservation = carReservationService.reserve(carType, reservationDateTime, days);

        if (reservation != null) {
            System.out.println("Reservation successful! Details: " + reservation);
        } else {
            System.out.println("Reservation failed. No " + carType + " cars are available.");
        }
    }
}