/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell User
 */
public class HomeWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here

       BlockingQueue q1 = new BlockingQueue(100);    
     BlockingQueue q2 = new BlockingQueue(100);
NameGenerater th1 = new NameGenerater(q1);

th1.start();
     ReaderClass []th=new ReaderClass[8];
     for (int i=0;i<8;i++){
         th[i]=new ReaderClass(q1, q2);
     }
     for (int i=0;i<8;i++){
    th[i].start();
}
ShowingInFile th3 = new ShowingInFile(q2);



th3.start();
        try {
            th1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HomeWork.class.getName()).log(Level.SEVERE, null, ex);
        }

for (int i=0;i<8;i++){
           try {
               th[i].join();
           } catch (InterruptedException ex) {
               Logger.getLogger(HomeWork.class.getName()).log(Level.SEVERE, null, ex);
           }
}

        try {
            th3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HomeWork.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
