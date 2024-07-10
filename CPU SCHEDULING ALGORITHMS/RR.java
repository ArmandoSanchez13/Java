import java.util.*;

public class RR implements Algorithm{
    private List<Task> queue;

    // Constructor to initialize the RR scheduler with a list of tasks
    public RR(List<Task> queue) {
        this.queue = queue;
    }

    // Executes the algorithm
    @Override
    public void schedule() {
        System.out.println("Round Robin Scheduling:"); // prints the scheduling algorithm
        int timeQuantum = 10; // Length of time quantum for round robin. 10ms

        while (!queue.isEmpty()) { // checks that it is not empty
            Task current = pickNextTask(); // gets the next task to be executed

            // Display data about the current executing tasks
            // Use the CPU class to run the task
            CPU.run(current, timeQuantum);

            // Updates the remaining burst time for the task
            int newBurst = current.getBurst() - timeQuantum;

            if (newBurst > 0) {  // If the task still has burst time, reinsert it into the queue
                current.setBurst(newBurst);
                queue.add(current);
            }
        }
    }

    // Picks the next task. First one in the queue
    @Override
    public Task pickNextTask() {
        return queue.remove(0); // gets and removes the first task in the queue
    }
}
