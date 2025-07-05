package LinkedList.Singlylinkedlist;

import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    User head = null;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        boolean found = false;
        for (int fid : user1.friendIds) {
            if (user2.friendIds.contains(fid)) {
                User friend = findUserById(fid);
                System.out.println("- " + friend.name + " (ID: " + fid + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No mutual friends.");
    }

    void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends connected.");
            return;
        }
        for (int fid : user.friendIds) {
            User friend = findUserById(fid);
            System.out.println("- " + friend.name + " (ID: " + fid + ")");
        }
    }

    void searchByUserName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                printUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No user found with name: " + name);
    }

    void searchByUserId(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("No user found with ID: " + userId);
        } else {
            printUser(user);
        }
    }

    void countFriendsForEachUser() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    void printUser(User u) {
        System.out.println("User ID: " + u.userId + ", Name: " + u.name + ", Age: " + u.age + ", Friends: " + u.friendIds.size());
    }

    void displayAllUsers() {
        User temp = head;
        if (temp == null) {
            System.out.println("No users in network.");
            return;
        }
        while (temp != null) {
            printUser(temp);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Alice", 22);
        network.addUser(2, "Bob", 25);
        network.addUser(3, "Charlie", 21);
        network.addUser(4, "David", 24);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(2, 4);

        System.out.println("\nAll Users:");
        network.displayAllUsers();

        System.out.println("\nDisplaying Alice's Friends:");
        network.displayFriends(1);

        System.out.println("\nMutual Friends between Alice and Bob:");
        network.findMutualFriends(1, 2);

        System.out.println("\nRemoving friend connection between Alice and Charlie:");
        network.removeFriendConnection(1, 3);
        network.displayFriends(1);

        System.out.println("\nSearching by User Name 'David':");
        network.searchByUserName("David");

        System.out.println("\nFriend counts for each user:");
        network.countFriendsForEachUser();
    }
}
