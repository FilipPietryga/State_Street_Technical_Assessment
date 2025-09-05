import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarReservationService {

    private final Map<CarType, Integer> availableCars;

    public CarReservationService(Map<CarType, Integer> availableCars) {
        this.availableCars = new HashMap<>(availableCars);
    }

    public CarReservation reserve(CarType carType, LocalDateTime reservationDateTime, int days) {
        int availableCarsForType = availableCars.get(carType);
        if (availableCarsForType == 0) {
            return null;
        }
        availableCars.put(carType, availableCarsForType - 1);
        return new CarReservation(carType, reservationDateTime, days);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarReservationService that = (CarReservationService) o;
        return Objects.equals(availableCars, that.availableCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(availableCars);
    }

    @Override
    public String toString() {
        return "CarReservationService{" +
                "availableCars=" + availableCars +
                '}';
    }
}
