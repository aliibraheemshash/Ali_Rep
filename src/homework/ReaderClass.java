/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dell User
 */
public class ReaderClass extends Thread{
    private BlockingQueue queue1;
    private BlockingQueue queue2;
    String result = "";
  
    public ReaderClass(BlockingQueue queue1,BlockingQueue queue2 ){
        this.queue1=queue1;
        this.queue2=queue2;
    }

    @Override
    public void run() {
        super.run(); 
        
        while (!queue1.isEmpty()){
           
         int numberOfnum=0;
      int numberOfChar=0;
      int numberOfExtra=0;
        Character ch = new Character(' ');
      char c;
      String fileName="";
        try {
            fileName = queue1.pop().toString();
        } catch (InterruptedException ex) {
            Logger.getLogger(ReaderClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = fileName;
      String st ="";
        try {
            st = FileUtils.readFileAsString(fileName);
        } catch (IOException ex) {
            Logger.getLogger(ReaderClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    //  st.split(" ");
  for(int i=0;i<st.length();i++){
      c=st.charAt(i);
      if(ch.isDigit(c))
          ++numberOfnum;
      else
          if(ch.isLetter(c))
              ++numberOfChar;
      else
             ++numberOfExtra; 
  }
        result = result +" " + numberOfChar +" of char " +numberOfnum +" of digits " +numberOfExtra+" of extra"; 
 
        try {
            queue2.add(result);
            //  }
        } catch (InterruptedException ex) {
            Logger.getLogger(ReaderClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
