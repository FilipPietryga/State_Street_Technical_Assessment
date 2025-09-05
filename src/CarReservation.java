import java.time.LocalDateTime;
import java.util.Objects;

public class CarReservation {
    private final CarType carType;
    private final LocalDateTime dateOfReservation;
    private final int days;
    private boolean completed;

    public CarReservation(CarType carType, LocalDateTime dateOfReservation, int days, boolean completed) {
        this.carType = carType;
        this.dateOfReservation = dateOfReservation;
        this.days = days;
        this.completed = completed;
    }

    public CarType getCarType() {
        return carType;
    }

    public LocalDateTime getDateOfReservation() {
        return dateOfReservation;
    }

    public int getDays() {
        return days;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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