import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public record CarReservationService(Map<CarType, Integer> availableCars) {

    public CarReservationService {
        if (availableCars == null) {
            throw new IllegalArgumentException("Available cars map cannot be null.");
        }
        availableCars = new HashMap<>(availableCars);
    }

    public CarReservation reserve(CarType carType, LocalDateTime reservationDateTime, int days) {
        Integer availableCarsForType = availableCars.get(carType);
        if (availableCarsForType == null || availableCarsForType == 0) {
            return null;
        }
        availableCars.put(carType, availableCarsForType - 1);
        return new CarReservation(carType, reservationDateTime, days);
    }
}
