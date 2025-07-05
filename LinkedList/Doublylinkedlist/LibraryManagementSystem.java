package LinkedList.Doublylinkedlist;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    String status;
    Book next, prev;

    Book(String title, String author, String genre, int bookId, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.status = status;
        this.next = this.prev = null;
    }
}

class LibraryDoublyLinkedList {
    Book head, tail;

    void addAtBeginning(String title, String author, String genre, int bookId, String status) {
        Book newBook = new Book(title, author, genre, bookId, status);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    void addAtEnd(String title, String author, String genre, int bookId, String status) {
        Book newBook = new Book(title, author, genre, bookId, status);
        if (tail == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    void addAtPosition(int position, String title, String author, String genre, int bookId, String status) {
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, status);
            return;
        }
        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, status);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, status);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("No books to remove.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    void updateAvailability(int bookId, String newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.status = newStatus;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void printBook(Book b) {
        System.out.println("Title: " + b.title + ", Author: " + b.author + ", Genre: " + b.genre + ", ID: " + b.bookId + ", Status: " + b.status);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 101, "Available");
        library.addAtBeginning("Clean Code", "Robert C. Martin", "Programming", 102, "Issued");
        library.addAtEnd("Atomic Habits", "James Clear", "Self-help", 103, "Available");
        library.addAtPosition(2, "Deep Work", "Cal Newport", "Productivity", 104, "Available");

        System.out.println("Books (Forward):");
        library.displayForward();

        System.out.println("\nBooks (Backward):");
        library.displayBackward();

        System.out.println("\nSearch by Title 'Atomic Habits':");
        library.searchByTitle("Atomic Habits");

        System.out.println("\nSearch by Author 'Paulo Coelho':");
        library.searchByAuthor("Paulo Coelho");

        System.out.println("\nUpdating availability status of Book ID 104:");
        library.updateAvailability(104, "Issued");

        System.out.println("\nRemoving book with ID 102:");
        library.removeByBookId(102);

        System.out.println("\nFinal Book List (Forward):");
        library.displayForward();

        System.out.println("\nTotal number of books in library: " + library.countBooks());
    }
}
