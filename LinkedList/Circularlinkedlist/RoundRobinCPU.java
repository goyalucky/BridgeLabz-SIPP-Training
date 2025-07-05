package LinkedList.Circularlinkedlist;

class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnAroundTime;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null, tail = null;

    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    void removeProcess(int processId) {
        if (head == null) return;
        if (head.processId == processId && head == tail) {
            head = tail = null;
            return;
        }
        Process temp = head, prev = tail;
        do {
            if (temp.processId == processId) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        int timeElapsed = 0;
        Process current = head;

        while (head != null) {
            System.out.println("\nCurrent Queue:");
            displayProcesses();

            if (current.remainingTime <= timeQuantum) {
                timeElapsed += current.remainingTime;
                current.turnAroundTime = timeElapsed;
                current.waitingTime = current.turnAroundTime - current.burstTime;
                System.out.println("Process " + current.processId + " executed and completed.");
                int pid = current.processId;
                current = current.next;
                removeProcess(pid);
                if (head == null) break;
            } else {
                timeElapsed += timeQuantum;
                current.remainingTime -= timeQuantum;
                System.out.println("Process " + current.processId + " executed for " + timeQuantum + " units.");
                current = current.next;
            }
        }
        System.out.println("\nAll processes completed.");
    }

    void calculateAverageTimes() {
        int totalProcesses = 0, totalWaiting = 0, totalTurnAround = 0;
        Process temp = head;
        if (temp == null) {
            System.out.println("No processes remaining.");
            return;
        }
        do {
            totalProcesses++;
            totalWaiting += temp.waitingTime;
            totalTurnAround += temp.turnAroundTime;
            temp = temp.next;
        } while (temp != head);

        double avgWaiting = (double) totalWaiting / totalProcesses;
        double avgTurnAround = (double) totalTurnAround / totalProcesses;

        System.out.println("Average Waiting Time: " + avgWaiting);
        System.out.println("Average Turn-Around Time: " + avgTurnAround);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID: " + temp.processId + ", BT: " + temp.burstTime + ", RT: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinCPU {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 6, 3);
        scheduler.addProcess(4, 8, 2);

        int timeQuantum = 3;

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\nSimulating Round-Robin Scheduling (Time Quantum = " + timeQuantum + "):");
        scheduler.simulate(timeQuantum);

        System.out.println("\nFinal Process Details:");
        scheduler.displayProcesses();

    }
}
