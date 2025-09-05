import java.time.LocalDateTime;
import java.util.Objects;

public class CarReservation {
    private final CarType carType;
    private final LocalDateTime dateOfReservation;
    private final int days;

    public CarReservation(CarType carType, LocalDateTime dateOfReservation, int days) {
        this.carType = carType;
        this.dateOfReservation = dateOfReservation;
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarReservation that = (CarReservation) o;
        return days == that.days && carType == that.carType && Objects.equals(dateOfReservation, that.dateOfReservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, dateOfReservation, days);
    }

    @Override
    public String toString() {
        return "CarReservation{" +
                "carType=" + carType +
                ", dateOfReservation=" + dateOfReservation +
                ", days=" + days +
                '}';
    }
}