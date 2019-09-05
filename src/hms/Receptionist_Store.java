
package hms;

import java.io.*;

public class Receptionist_Store
{
    
    public static void storeReceptionist(ManageReception receptionist,String filename) throws Exception
    {
    
        PrintWriter pwriter=new FileEngine().writer(filename);
        
        pwriter.print(receptionist.userid+"   ");
        pwriter.print(receptionist.firstName+"   ");
        pwriter.print(receptionist.lastName+"   ");
        pwriter.print(receptionist.age+"   ");
        pwriter.print(receptionist.experience+"   ");
        pwriter.println(receptionist.date+"   ");
        
        
        pwriter.flush();
        pwriter.close();
        
    }
      
}
