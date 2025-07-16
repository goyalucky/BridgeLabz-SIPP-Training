import java.util.*;

import javax.lang.model.util.Elements;

class Stall {
    String name;
    int footfall;

    Stall(String name, int footfall) {
        this.name = name;
        this.footfall = footfall;
    }

    public String toString() {
        return name + " - " + footfall + " visitors";
    }
}

public class FoodFest {
    public static void main(String[] args) {
        List<Stall> zone1 = Arrays.asList(
            new Stall("Taco Town", 150),
            new Stall("Burger Bay", 200),
            new Stall("Pizza Point", 250)
        );

        List<Stall> zone2 = Arrays.asList(
            new Stall("Sushi Stop", 100),
            new Stall("Noodle Nest", 220),
            new Stall("Curry Corner", 300)
        );

        List<Stall> merged = mergeSortedLists(zone1, zone2);

        System.out.println("Master Footfall List:");
        for (Stall s : merged) {
            System.out.println(s);
        }
    }

    static List<Stall> mergeSortedLists(List<Stall> list1, List<Stall> list2) {
        List<Stall> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).footfall <= list2.get(j).footfall) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }

        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));

        return merged;
    }
}


/*

in this i covered 7 modules 

Core-Java - In this module, I focused on mastering the fundamentals of Core Java, including key programming elements such as variables, data types, 
operators, and control flow statements (if-else, loops, switch). I developed a strong understanding of Object-Oriented Programming (OOPs) 
concepts like encapsulation, inheritance, polymorphism, and abstraction. Additionally, I explored Java Strings and Arrays, working on various 
real-world problems to strengthen logical thinking. I also practiced solving problems using Java’s built-in functions, improving my efficiency 
and coding fluency.

DSA - In this module, I gained both practical and theoretical knowledge of key data structures, including HashMap, HashSet, LinkedList, Stack, 
and Queue. I learned how to implement and apply these structures to solve a variety of computational and logical problems efficiently. 
Additionally, I studied the fundamentals of Algorithm Runtime Analysis and Big O Notation, which enabled me to evaluate the time and space 
complexity of different approaches and write optimized, scalable code. As part of applied learning, I also created a dedicated "Scenario" 
folder, where I solved real-life problem statements using these concepts, further strengthening my problem-solving and implementation skills.

Oops - Object-Oriented Programming (OOP) In this module, I studied the core principles of Object-Oriented Programming (OOP) in Java, with a 
strong emphasis on encapsulation, inheritance, polymorphism, and abstraction. I explored object modeling through the use of class, object, 
and sequence diagrams, gaining a deeper understanding of object interactions and system design. Additionally, I worked with interface classes 
to implement abstraction and multiple inheritance in Java, strengthening my ability to write modular, reusable, and scalable code.

Searching - In this module, I learned the concepts and implementations of Linear Search and Binary Search in Java. I explored their real-world 
applications, understanding where each approach is most effective. Additionally, I studied and compared their time complexities—O(n) for 
Linear Search and O(log n) for Binary Search—enhancing my ability to choose the most efficient search technique based on the problem context.

Sorting - In this module, I studied a wide range of sorting algorithms, including Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, 
Quick Sort, Heap Sort, and Counting Sort. I explored their implementation in Java, understood their real-world use cases, and analyzed their 
time and space complexities. This helped me develop the ability to select the most appropriate sorting technique based on data size, 
structure, and performance requirements.

Workshop - In this workshop module, I tackled a variety of scenario-based and case study questions by applying key programming concepts from 
OOPs, DSA, Searching, Sorting, and core Java structures like HashMap, HashSet, Arrays, Strings, Stacks, Queues, and LinkedLists. These 
real-world problems helped me strengthen both logic-building and system design skills.
Notable projects and problem scenarios include:

1) Billing System
2) Coffee Counter Chronicles
3) Garage Management System
4) Browser History Navigation
5) Music Playlist Queue
6) Online Store Billing System

 */



