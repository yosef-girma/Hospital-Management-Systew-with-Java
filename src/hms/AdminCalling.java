
package hms;
import static hms.Banner.clearScreen;
import static hms.Banner.makeGap;
import static hms.Banner.showBanner;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static hms.ManageDoctor.operateDoctorChoice;
import static hms.ManageReception.operateReceptionChoice;
import static hms.Patient.input;
import static hms.Room.roomDetails;

import java.util.Scanner;

public class AdminCalling  implements CommonInterface{

public static String confirm() throws Exception
{
    
     
        System.out.println("Are you sure you want delete the record(Y/N)");
        
        
       
     
      char   confirm=input.next().charAt(0);
        if(confirm=='y'|| confirm=='Y')
        {
            System.out.println("Enter Id");
          return new Scanner(System.in).next();     
            
        }
        else
        {
            
            Banner.showAdminOptions();
            return null;
        }  
}
    public static  void showAdminDetail() throws Exception
    {
        
        int choice=Banner.promptChoice();
        
        switch(choice)
        {
            
            case 1:
              clearScreen();
                   showBanner();
                   makeGap();
                   
                     makeGap();
                operateDoctorChoice();
            
                break;
            case 2:
             clearScreen();
                   showBanner();
                   makeGap();
                   
                     makeGap();
                 operateReceptionChoice();
  
             
                              break;
            case 3:
                clearScreen();
                   showBanner();
                   makeGap();
                   
                     makeGap();
                   roomDetails();
               
                   break;
                   
            case 4:
              new  AdminCalling().logout();
               
              break;
                
           
        }
        
        
    }
   
    
    
    public boolean login() {
        
        return true;
    }
    
    
    public  void logout()
    {
        Banner.clearScreen();
        Banner.showBanner();
        try {
            Banner.showHome();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminCalling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminCalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
