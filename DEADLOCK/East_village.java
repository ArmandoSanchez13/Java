import java.util.concurrent.Semaphore;
import java.util.Random;

public class East_village extends Thread
{
   //private Semaphore sem;
   public Semaphore sem; //instance that controls access
   public int num; //number of villager

   public East_village(Semaphore sem, int num){ //constructor
       this.sem = sem;
       this.num = num;
   }
    @Override
    public void run(){
      while(true){
          try{
            sem.acquire(); //tries to acquire a perment. it decrements available permits since its acquired 
            System.out.println("East villager "  + num + " is traveling on the road");
            int think = new Random() .nextInt(3000); //random time within 3 seconds
           // Thread.sleep(think);
            action(); //displays random actions 

            System.out.println("East villager " + num + " has shared their produce");

            sem.release(); //releases the perment. it increments available permits since its released
            Thread.sleep(think); //sleeps thread for a random time 

          } catch(InterruptedException e) { //catches errors
          e.printStackTrace();
          }
       }
    }
    private void action() { //random activity to display
      String [] action = {
         "Eating a donut",
         "Reading a book",
         "Playing cards"
      };
      Random random = new Random();
      int i = random.nextInt(action.length);
      System.out.println("East villager " + num + " is " +action[i]);
    }
}