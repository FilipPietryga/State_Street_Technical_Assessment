import java.time.LocalDateTime;

public class Main {
    private static final CarReservationService carReservationService = new CarReservationService();
    public static void main(String[] args) {
        CarReservation carReservation = carReservationService.reserve(CarType.SUV, LocalDateTime.now(), 10);
        System.out.print(carReservation);
    }
}