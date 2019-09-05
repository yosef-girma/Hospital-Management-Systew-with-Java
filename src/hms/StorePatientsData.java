
package hms;


import java.io.*;
import static hms.FileEngine.writer;
public class StorePatientsData {
    
    public static Patient my_pat;
    
    public  static void addPatientsData(Patient patient_data) throws Exception
    {
        
        String filename="patients_info.txt";
        
        PrintWriter pwriter=writer(filename);
        pwriter.println(
                
                patient_data.patient_id +"  "+
                        patient_data.patientLname +"  "+
                        patient_data.patientFname +"  "+
                        patient_data.patientGender +"  "+
                        patient_data.patient_age +"  "+
                        patient_data.localdate +"  "
                
                
        );
        
        pwriter.flush();
        pwriter.close();
    }
}
