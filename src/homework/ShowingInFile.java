/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell User
 */
public class ShowingInFile extends Thread{
    private BlockingQueue queue ;
    private String str;

    public ShowingInFile(BlockingQueue queue) {
        this.queue=queue;
    }

    @Override
    public void run(){
       
       for (int i=0;i<100;i++)
       {
            try {
                str= queue.pop().toString();
             
                FileUtils.appendStringToFile("file.txt",str);
            } catch (IOException ex) {
                Logger.getLogger(ShowingInFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShowingInFile.class.getName()).log(Level.SEVERE, null, ex);
            }

       }
    }
}
