
package hms;


import static hms.FileEngine.writer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


public class StoreDiagonsis extends DiagonsisReport{
    
    
    
    public  static void patientDiagonsisReportStore(DiagonsisReport patient) throws Exception
    {
        
        String filename="diagonsis_report.txt";
        PrintWriter pwriter=writer(filename);
        
        pwriter.println(
                
                patient.pid + "  "+
                        patient.docId + "  "+
                        patient.Room+ "  " +
                        
                        
                        patient.consulation_date + "  "+
                        patient.date+" "
                
        );
        
        
        pwriter.flush();
        pwriter.close();
    }
    public void prescribedMedicine(String pid,ArrayList<String> medicine_list) throws Exception
    {
        
        String filename="prescribed_medicine.txt";
        PrintWriter pwriter=writer(filename);
        
        Iterator iterator=medicine_list.iterator();
        pwriter.print(pid);
        while(iterator.hasNext())
        {
            pwriter.println(
                    "   "+iterator.next()+"   "
                    
            );
            
        }
        
        pwriter.flush();
        pwriter.close();
    }
}
