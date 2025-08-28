// StringUtilsTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test void testReverse() { assertEquals("olleh", utils.reverse("hello")); }
    @Test void testPalindrome() { assertTrue(utils.isPalindrome("madam")); }
    @Test void testNotPalindrome() { assertFalse(utils.isPalindrome("hello")); }
    @Test void testUpperCase() { assertEquals("HELLO", utils.toUpperCase("hello")); }
}
