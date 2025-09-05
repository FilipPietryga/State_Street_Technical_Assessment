import java.time.LocalDateTime;

public record CarReservation(CarType carType, LocalDateTime dateTime, int days) { }