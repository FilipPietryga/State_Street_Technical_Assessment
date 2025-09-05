import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CarReservationService {

    private final Map<CarType, Integer> availableCars = new HashMap<>();

    public CarReservationService() {
        availableCars.put(CarType.Sedan, 5);
        availableCars.put(CarType.SUV, 3);
        availableCars.put(CarType.Van, 4);
    }

    public CarReservation reserve(CarType carType, LocalDateTime reservationDateTime, int days) {
        int availableCarsForType = availableCars.get(carType);
        if (availableCarsForType == 0) {
            return null; // could not create a CarReservation
        }
        availableCars.put(carType, availableCarsForType - 1);
        return new CarReservation(carType, reservationDateTime, days, false);
    }

    public boolean retreat(CarReservation carReservation) {
        CarType carType = carReservation.getCarType();
        Integer availableCarsForType = availableCars.get(carType);
        if(availableCarsForType == null) {
            return false;
        }
        availableCars.put(carType, availableCarsForType + 1);
        carReservation.setCompleted(true);
        return true;
    }

    public Map<CarType, Integer> checkAvailableCars() {
        return availableCars;
    }

    public Integer checkAvailableCarsForCarType(CarType carType) {
        return availableCars.get(carType);
    }
}
