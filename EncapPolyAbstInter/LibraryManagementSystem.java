package EncapPolyAbstInter;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Reserved: " + (isReserved ? "Yes" : "No"));
        if (isReserved) {
            System.out.println("Borrower: " + borrower);
        }
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrower(borrowerName);
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrower(borrowerName);
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrower(borrowerName);
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[4];
        items[0] = new Book("B101", "The Alchemist", "Paulo Coelho");
        items[1] = new Magazine("M201", "Forbes", "Various");
        items[2] = new DVD("D301", "Inception", "Christopher Nolan");
        items[3] = new Book("B102", "1984", "George Orwell");

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                if (res.checkAvailability()) {
                    res.reserveItem("Prashant");
                }
            }
        }
    }
}
