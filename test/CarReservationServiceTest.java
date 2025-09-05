import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarReservationServiceTest {

    private CarReservationService service;

    @BeforeEach
    void setUp() {
        Map<CarType, Integer> initialCars = new HashMap<>();
        initialCars.put(CarType.SEDAN, 2);
        initialCars.put(CarType.SUV, 1);
        initialCars.put(CarType.VAN, 0);
        service = new CarReservationService(initialCars);
    }

    @Test
    void testSuccessfulReservation() {
        assertEquals(2, service.availableCars().get(CarType.SEDAN));

        LocalDateTime reservationTime = LocalDateTime.of(2025, 10, 26, 10, 0);
        CarReservation reservation = service.reserve(CarType.SEDAN, reservationTime, 3);

        assertNotNull(reservation);
        assertEquals(1, service.availableCars().get(CarType.SEDAN));
        assertEquals(CarType.SEDAN, reservation.carType());
        assertEquals(reservationTime, reservation.dateTime());
    }

    @Test
    void testFailedReservationDueToNoCars() {
        assertEquals(0, service.availableCars().get(CarType.VAN));

        LocalDateTime reservationTime = LocalDateTime.of(2025, 10, 26, 11, 0);
        CarReservation reservation = service.reserve(CarType.VAN, reservationTime, 5);

        assertNull(reservation);
        assertEquals(0, service.availableCars().get(CarType.VAN));
    }
}