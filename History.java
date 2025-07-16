class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    public HistoryNode(String url) {
        this.url = url;
    }
}

abstract class NavigationSystem {
    public abstract void visit(String url);
    public abstract boolean back();
    public abstract boolean forward();
    public abstract String getCurrentPage();
}

class BrowserHistory extends NavigationSystem {
    private HistoryNode current;

    public BrowserHistory(String homepage) {
        current = new HistoryNode(homepage);
    }

    @Override
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    @Override
    public boolean back() {
        if (current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }

    @Override
    public boolean forward() {
        if (current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    @Override
    public String getCurrentPage() {
        return current.url;
    }
}

class MusicPlayerHistory extends NavigationSystem {
    private HistoryNode current;

    public MusicPlayerHistory(String firstTrack) {
        current = new HistoryNode(firstTrack);
    }

    @Override
    public void visit(String track) {
        HistoryNode newNode = new HistoryNode(track);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    @Override
    public boolean back() {
        if (current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }

    @Override
    public boolean forward() {
        if (current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    @Override
    public String getCurrentPage() {
        return current.url;
    }
}

public class History {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("home.com");
        browser.visit("page1.com");
        browser.visit("page2.com");
        System.out.println("Current Page: " + browser.getCurrentPage()); 

        browser.back();
        System.out.println("After Back: " + browser.getCurrentPage()); 

        browser.forward();
        System.out.println("After Forward: " + browser.getCurrentPage()); 

        NavigationSystem musicHistory = new MusicPlayerHistory("Track 1");
        musicHistory.visit("Track 2");
        musicHistory.visit("Track 3");
        musicHistory.back();
        System.out.println("Current Track: " + musicHistory.getCurrentPage()); 
    }
}
