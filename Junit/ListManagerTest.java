// ListManagerTest.java
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    ListManager manager = new ListManager();

    @Test void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        manager.removeElement(list, 2);
        assertFalse(list.contains(2));
    }

    @Test void testGetSize() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        manager.addElement(list, 6);
        assertEquals(2, manager.getSize(list));
    }
}
