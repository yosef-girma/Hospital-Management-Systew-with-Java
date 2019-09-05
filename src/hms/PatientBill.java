
package hms;

import java.io.PrintWriter;


public class PatientBill
{
    private String pid;
    private String reg_fee;
    private String service_fee;
    private String pharmacy_fee;
    private String room_fee;
    
    public  void storeBile() throws Exception
    {
  String filename="patient_bill.txt";
  
  
  PrintWriter pwriter=new FileEngine().writer(filename);
  
  pwriter.println(pid+" "+reg_fee+" "+service_fee+" "+pharmacy_fee+" "+room_fee);
  
  
  
  
  
  
  
  
  pwriter.flush();
  pwriter.close();
  
  
  
  
  
  
  
    }






















    
}
