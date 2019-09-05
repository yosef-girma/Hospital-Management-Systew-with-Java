
package hms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class FileEngine 
{


  public static PrintWriter writer(String filename) throws Exception
    {
        File file=new File(filename);
        file.createNewFile();
        FileWriter fileWriter=new FileWriter(file,true);
       
        BufferedWriter bwriter=new BufferedWriter(fileWriter);
        
        PrintWriter pwriter=new PrintWriter(bwriter);
         
        return pwriter;
    }




  
}
