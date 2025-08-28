import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class FileProcessorTest {
    FileProcessor processor = new FileProcessor();
    String filename = "test.txt";

    @Test void testWriteAndRead() throws IOException {
        processor.writeToFile(filename, "Hello JUnit");
        assertEquals("Hello JUnit", processor.readFromFile(filename));
    }

    @Test void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(filename, "Content");
        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test void testFileNotFound() {
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }
}
