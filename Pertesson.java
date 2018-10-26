/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertesson;

/**
 *
 * @author Chamin
 */
public class Pertesson {
    
    int turn;
    boolean flag[]=new boolean[2];
    
    int counter=0;
    int sharedVariable=13;
    
    private class Process implements Runnable{
        int processId;
        
        public Process(int id){
            this.processId=id;
        }
        public void run(){
        //do{
        flag[processId]=true;
        turn=processId;
        int other =1-processId;
        
        while(turn==processId && flag[other])
        System.out.println(Thread.currentThread().getName()+" is in critical section");
        
        if(processId==0){
            sharedVariable++;
            System.out.println("Variable value is "+sharedVariable);
            }
        else{
            sharedVariable--;
            System.out.println("Variable value is "+sharedVariable);
        }
        counter++;
        System.out.println("Counter "+counter);
        
        flag[processId]=false;
                         
    //}while(counter<2);
        
    }
}
       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pertesson m=new Pertesson();
        Pertesson.Process p1=m.new Process(0);
        Pertesson.Process p2=m.new Process(1);
        
        Thread t1=new Thread(p1,"Thread-01");
        Thread t2=new Thread(p2,"Thread-02");
        
        t1.start();
        t2.start();
                
        
        
        
                

    }
    
}
