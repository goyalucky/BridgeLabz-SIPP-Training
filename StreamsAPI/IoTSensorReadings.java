import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(40, 65, 30, 75, 55, 20);
        int threshold = 50;

        System.out.println("Sensor readings above threshold (" + threshold + "):");
        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("Reading: " + r));
    }
}
