
package hms;

import static hms.Banner.promptChoice;

import java.io.FileNotFoundException;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;
public class Banner {
    
    public static void showBanner() {
        out.println("       *************************************************************************************");
        out.println("       *************************************************************************************");
        out. println("                 *****************HOSPITAL MANAGEMENT SYSTEM ******************");
        out.println("       *************************************************************************************\n");
        out.println("       *************************************************************************************");
    }    

        public static void showDoctorBanner() {
        out.println("       ******************Doctor List*******************************************************************");
        out.println("       *************************************************************************************");
        out. println("   Id        F-Name     L-Name        Experience     Age      Specialization      Registration-Date                                                                                    ");
        out.println("******************************************************************************************\n");
        
    }    
        
        public static void showReceptionistBanner()
        {
        out.println("       **************Receptionist List************************************************");
        out.println("       *************************************************************************************");
        out. println("   Id   F-Name   L-Name    Experience   Age         Registration-Date                                                                                    ");
        out.println("******************************************************************************************\n");
                               
        }
        
        public static void showPharmacyBanner()
        {
            
        out.println("       **************Receptionist List************************************************");
        out.println("       *************************************************************************************");
        out. println("   Id   Name      Category   Amount      Price   Expired-Date                                                                                    ");
        out.println("******************************************************************************************\n");
                                
            	
        }        
   
        public static void showPatientBanner()
        {
            
             out.println("       **************Receptionist List************************************************");
             out.println("       *************************************************************************************");
             out. println("   Id   F-Name   L-Name    Gender      Age            Registration-Date                                                                                    ");
             out.println("******************************************************************************************\n");
                               
            
        }      
public static void clearScreen()
    {
        for(int i=0;i<50;i++)
        {
            System.out.println("\n");
        }
        
        
        
    }
    public static void makeMidGap()
    {
          for(int i=0;i<6;i++)
          System.out.println("\n"); 
    }
    public static void makeGap()
    {
        for(int i=0;i<3;i++)
          System.out.println("\n");    
        
    }
    public static int showHome() throws FileNotFoundException, Exception {
        out.println("\n                       [1] -> Administrator Login");
        out.println("                       [2] -> Doctor Login");
        out.println("                       [3]->Pharmacists login");
        out.println("                       [4] -> Receptionist Login");
        out.println("                       [5]->Exit");
        out.println("                  ----------------------------------------");
        
        
          
    return promptChoice();
   
    //showHomeDetail(menu_choice);
    }
    public static  void showReceptionistOption() throws Exception
    {
        
        out.println("\n                 [1] -> Add Patient");
        out.println("                   [2] ->Search Patient");
         out.println("                  [3] ->View All Patient");
       out.println("                   [4]->Leave Patient");   
        out.println("                   [5]->Logout");
        out.println("               ----------------------------------------");
          makeMidGap();
        ReceptionistCalling.showReceptionistDetail();
        
    }
    public static void showPharmacistsOption() throws FileNotFoundException, Exception
    {
        out.println("\n                [1] -> Add Medicine");
        out.println("                  [2] -> Search Medicine");
        
        out.println("                  [3] -> Update Medicine");
        out.println("                  [4] -> Delete Medicine");
        out.println("                  [5]->View All Medicine");
        out.println("                  [6]->Logout");
        out.println("----------------------------------------");
        makeMidGap();
        
         PharmacisitCalling.showPharmacisitDetail();
    }
    
    
    
    
    public static void showAdminOptions() throws Exception {
        out.println("           ----------------------------------------\n");
        out.println("                   **** ADMIN OPERATIONS ****");
        out.println("                     [1] ->Manage Doctor ");
        out.println("                     [2] -> Manage Receptionist");
        out.println("                     [3] -> Manage Room"); 
        out.println("                    [4] -> Logout");
        out.println("               ----------------------------------------");
          makeMidGap();
         AdminCalling.showAdminDetail();
        
    }
    public static void showDoctorOption() throws Exception
    {
        out.println("                 ----------------------------------------\n");
        out.println("\n                     [1] ->patientinfo");
        out.println("                     [2] -> Patient Diagonosis Report");       
        out.println("                     [3] -> Logout");
        out.println("                    ----------------------------------------");
          makeMidGap();
        DoctorCalling.showDoctorDetail();
    }
    public static Scanner scanner() {
        return new Scanner(in);
        
    }
    
    public static void println(String content) {
        out.println(content);
    }
    public static void print(String content) {
        out.print(content);
    }
    
    public static int promptChoice() { 
        out.print("Please enter your choice : ");
        return scanner().nextInt();
    }
}
