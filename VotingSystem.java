import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 5);
        voteMap.put("Bob", 3);
        voteMap.put("Charlie", 7);
        voteMap.put("Bob", voteMap.get("Bob") + 2);

        LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>();
        orderedVotes.put("Alice", 5);
        orderedVotes.put("Bob", 5);
        orderedVotes.put("Charlie", 7);

        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);

        System.out.println("HashMap: " + voteMap);
        System.out.println("LinkedHashMap: " + orderedVotes);
        System.out.println("TreeMap: " + sortedVotes);
    }
}
