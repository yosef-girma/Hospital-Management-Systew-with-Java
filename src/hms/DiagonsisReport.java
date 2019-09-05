
package hms;



import static hms.StoreDiagonsis.patientDiagonsisReportStore;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class DiagonsisReport {
    
    protected static ArrayList<String> prescribed_medicine_list=new ArrayList<String>();
     protected static  DiagonsisReport patient_rep;
    protected   String pid;
    protected   String docId;
    protected  static String Room;
    protected   String prescribeMedicine;
  protected   LocalDate date;
    
        static int con_day;
        static int con_month;
        static int con_year;
 protected LocalDate consulation_date;
       
    public static void patientInfo()
    {
        
        
    }
    public static void patientDiagonsisReport() throws FileNotFoundException, Exception
    {
       patient_rep=new DiagonsisReport();
        
       Scanner input=new Scanner(System.in);
       DiagonsisReport patien=new DiagonsisReport();
       String fileName="patient_diagonasis.txt";
      
      
        System.out.println("Patient Id");
      
         patient_rep.pid = input.next();
        System.out.println(" Doctor  Id");
        patient_rep.docId=input.next();
         String  cont=null;
        System.out.println("Prescribed Medicine");
           do
           {
                String med_name=" ";
                String med_amt=" ";
                System.out.println("Medicine Name");
                 med_name=input.next();
                System.out.println("Medicine Amount");
                med_amt=input.next();
                System.out.println("Do you have any more Medicine");
                               
                prescribed_medicine_list.add(med_name);
                prescribed_medicine_list.add(med_amt);
                cont=input.next();                
           }
           while(cont=="Y" || cont=="y");
           
         Room=optionRoom();

        System.out.println("Consultation Date -->");
        
         System.out.println("          Consulation day");
                con_day= input.nextInt();
         System.out.println("          Consulation month");              
         con_month=input.nextInt();
        System.out.println("           Consulation Year"); 
         con_year=input.nextInt();
         
          patient_rep.consulation_date=LocalDate.of(con_day,con_month,con_year);
          patient_rep.date=LocalDate.now();
        
        
         
          patientDiagonsisReportStore(patient_rep);
          
    
    }
    public static String optionRoom() throws FileNotFoundException
    {
        String room_no=null;
        Scanner inputt=new Scanner(System.in);
        System.out.println("Need room ? [1]-->Yes ---- [2] -->[NO]"); 
        String op=inputt.next();
         op=op.toLowerCase();
        if(op.equals("1"))
        {
        room_no=new Room().checkRoomAvaliablity();   
        }
      
       return room_no;
    }
  
    
}
