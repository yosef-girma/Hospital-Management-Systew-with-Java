
package hms;
import static hms.Banner.clearScreen;
import static hms.Banner.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;


import java.util.Date;
public class Patient  
{
     static  Scanner input=new Scanner(System.in);
     String patient_id;
     String patientFname;
     String patientLname;
     String patientGender;
        
     int  patient_age;
     String room;
     Date date;
     LocalDate localdate;
     
    public static Patient patient=new Patient();
    
    
    public static void showPatientList() throws FileNotFoundException
    {
        
        
        
        
         File file=new File("patients_info.txt");
        Scanner reader=new Scanner(file);
        
        clearScreen();
      
          showPatientBanner();
        while(reader.hasNext())
        {
            
        
            System.out.println(
                    reader.next()+"         "
                               +   reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()
                           
                            );
            
        }
        
     
         reader.close();
    }
    public static void addPatientsData() throws Exception
            
    {
        
       
       System.out.print(" patientid:-");
      patient.patient_id=input.next();
      System.out.print("First-Name:-");
      patient.patientFname=input.next();
      
       System.out.print("Last-Name:-");
      patient.patientLname=input.next();
        System.out.print("Gender:-");
     patient. patientGender=input.next();
      //  System.out.print("patientdisease:-");
      //  patient.disease=input.next();
        System.out.print("Age:-");
      patient.patient_age=input.nextInt();
        //System.out.print("Room of patient:-");
        //patient. room=input.next();
       
       patient.localdate=LocalDate.now();
       new StorePatientsData().addPatientsData(patient);
       
    }
    
    public static void leave()
    {
		
        System.out.println("please enter the id of patient that to be leave");  
       // patientid=input.next();
    }
    public static void searchPatient() throws FileNotFoundException
    {
     
        
        
        System.out.print("Enter Patient Id:-");
            String  patient_id=input.next();
            
            boolean found=false;
              File file=new File("patients_info.txt");
             Scanner reader=new Scanner(file);
             
        
                while(reader.hasNext())
        {
            
            
            
                if(patient_id.equals(reader.next()))
            
                        {
                            found=true;
                       
                             System.out.println(" Name :- "+" "+reader.next()+" "+reader.next());
                             
                                
                            System.out.println( " Gender:- "+" "+reader.next());
                            
                               
                          
                           
                            System.out.println( "Age:-"+" "+reader.next() );
                              System.out.println( "Registration Date:-  "+" "+reader.next() );
                           
                        }
      
        }
                if(!found)
                {
                    System.out.println("No such Patient found");
                }
    }
   
    public static void showPatient()
    {
        
    }
    public static void room() throws Exception
    {
        System.out.println(" [1]. Available Room");
        System.out.println(" [2]. View All Rooms");
        System.out.println(" [3] back");
        int choice=Banner.promptChoice();
      
        switch(choice)
        {
            case 1:
               new  Room().availableRooms();
                break;
            case 2:
                Room.viewAllRooms();
                break;
            case 3:
                Banner.showReceptionistOption();
                break;
                
            
        }
    }
    
    
    
    public void leavePatient()
    {
        //checkBill
        //free holded room if there 
        
        
        
        
    }
    
    public void patientBill()
    {
        //room charge,service charge,Medicine charge,Registraion charge
        
        
        
        
        
    
        
        
        
    }
    
    
    
    
    
    
}




