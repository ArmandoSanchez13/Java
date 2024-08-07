import java.util.*;

public class Priority implements Algorithm{
    private List<Task> queue;
     //constructor that initializes priority with a list of tasks
    public Priority(List<Task> queue) {
        this.queue = queue;
    }
    //executes the algorithm
    @Override
    public void schedule() {
        System.out.println("Priority Scheduling:"); //prints the scheduling algorithm

        while (!queue.isEmpty()) { //checks that it is not empty
            Task current = pickNextTask(); // gets next task to be executed
            // displays data about the current executing tasks
            CPU.run(current,0); //uses the cpu class to run the tasks
            // removes the executed task from the queue
            queue.remove(current);
        }
    }
    //picks the next task. based on priority
    @Override
    public Task pickNextTask() { 
        //find the biggest value in the queue
        return Collections.max(queue, Comparator.comparingInt(Task::getPriority));
    }
}
