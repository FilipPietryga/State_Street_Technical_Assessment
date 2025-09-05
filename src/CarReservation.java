import java.time.LocalDateTime;
import java.util.Objects;

public class CarReservation {
    private final CarType carType;
    private final LocalDateTime dateTime;
    private final int days;

    public CarReservation(CarType carType, LocalDateTime dateTime, int days) {
        this.carType = carType;
        this.dateTime = dateTime;
        this.days = days;
    }

    public CarType getCarType() {
        return carType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarReservation that = (CarReservation) o;
        return days == that.days && carType == that.carType && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, dateTime, days);
    }

    @Override
    public String toString() {
        return "CarReservation{" +
                "carType=" + carType +
                ", dateOfReservation=" + dateTime +
                ", days=" + days +
                '}';
    }
}