import java.util.concurrent.Semaphore;

public class RoadController
{  
   public static void main(String[] args){
      Semaphore sem = new Semaphore(1); // 1 counts (available permits)

      int numberofeastvillagers = 3; //number of villagers
      int numberofwestvillagers = 3; //number of villagers
      //creates and starts threads
      for (int i = 1; i<=numberofeastvillagers; i++){
         East_village eastvil = new East_village(sem, i); //creates two instances
         eastvil.start(); //creates two instances
        //eastvil.join(); //starts thread after the previous one ends(dies)
      }
      //creates and starts threads
       for (int i = 1; i<=numberofwestvillagers; i++){
         West_village westvil = new West_village(sem, i); //creates two instances
         westvil.start(); //creates two instances
        //eastvil.join(); //starts thread after the previous one ends(dies)
      }
   }
}