import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero!");
        return a / b;
    }

    @Test void testException() {
        assertThrows(ArithmeticException.class, () -> divide(5, 0));
    }
}
