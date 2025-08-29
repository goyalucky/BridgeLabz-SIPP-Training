import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "hello world hello java java stream stream stream";
        Map<String, Long> wordCount = Arrays.stream(paragraph.split(" "))
            .collect(Collectors.toMap(w -> w, w -> 1L, Long::sum));
        System.out.println(wordCount);
    }
}
