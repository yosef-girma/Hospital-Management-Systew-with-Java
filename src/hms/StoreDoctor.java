
package hms;

import java.io.PrintWriter;


public class StoreDoctor extends ManageDoctor {
    public  static void storeDoctorData(ManageDoctor doctor,String filename) throws Exception
    {
        
        
        PrintWriter pwriter=new FileEngine().writer(filename);
        
        pwriter.println(
                
                doctor.userid + "  "+
                        doctor.firstName + "  "+
                        doctor.lastName + "  "+
                        
                        doctor.specialization + "  "+
                        doctor.experience + "  "+
                        doctor.age + "  "+
                        doctor.date+" "
                                
        );
        
        
        pwriter.flush();
        pwriter.close();
    }
    
    
}
