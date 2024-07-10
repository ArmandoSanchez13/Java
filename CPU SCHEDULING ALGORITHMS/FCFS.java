import java.util.*;

public class FCFS implements Algorithm{
    private List<Task> queue;
    //constructor that initializes fcfs with a list of tasks
    public FCFS(List<Task> queue) {
        this.queue = queue;
    }
    //executes the algorithm
    @Override
    public void schedule() {
        System.out.println("FCFS Scheduling:"); //prints the scheduling algorithm

        while (!queue.isEmpty()) { //checks that it is not empty
            Task current = pickNextTask(); // gets next task to be executed
            // displays data about the current executing tasks
          
            CPU.run(current,0); //uses the cpu class to run the tasks
            // removes the executed task from the queue
            queue.remove(current);
        }
    }
    //picks the next task. First one in queue
    @Override
    public Task pickNextTask() {
        return queue.get(0); // gets the first task in the queue
    }
}