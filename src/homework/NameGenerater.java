/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell User
 */
public class NameGenerater extends Thread{
    private BlockingQueue queue;
    public NameGenerater(BlockingQueue queue){
        this.queue=queue;
    }
    @Override
    public void run(){
        super.run();
        for (int i=0;i<100;i++){
            try {
                queue.add("data\\f"+i+".txt");
            } catch (InterruptedException ex) {
                Logger.getLogger(NameGenerater.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
}
