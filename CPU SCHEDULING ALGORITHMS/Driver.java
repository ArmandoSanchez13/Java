import java.util.*;
import java.io.*;

public class Driver
{
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String file = scanner.nextLine();


        BufferedReader inFile = new BufferedReader(new FileReader(file));

        String schedule;

        // create the queue of tasks
        List<Task> queue = new ArrayList<Task>();

        // read in the tasks and populate the ready queue        
        while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }

        inFile.close();
        
        Algorithm scheduler = null;
        
   
       System.out.print("Choose the scheduling algorithm (FCFS, PRI, RR): ");
       String choice = scanner.nextLine().toUpperCase();

        switch(choice) {
            case "FCFS":
                scheduler = new FCFS(queue);
                break;
        
            case "PRI":
                scheduler = new Priority(queue);
                break;
            case "RR":
                scheduler = new RR(queue);
                break;
     
            default:
                System.err.println("Invalid algorithm");
                System.exit(0);
        }

        // start the scheduler
        scheduler.schedule();   
        scanner.close(); //closes user input
    }
}
