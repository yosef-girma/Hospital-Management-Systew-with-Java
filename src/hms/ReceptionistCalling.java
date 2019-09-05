

package hms;

import static hms.Banner.*;
import static hms.Patient.*;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.logging.Level;

import java.util.logging.Logger;


public class ReceptionistCalling  implements CommonInterface{
     Scanner input=new Scanner(System.in);
     private String patientName;
     private String patientGender;
     private String disease; 
    public boolean login()
    {
      return true;  
    }
    public static  void showReceptionistDetail() throws Exception
    {
        int choice=promptChoice();
        
        switch(choice)
        {
            
            case 1:
                new Patient().addPatientsData();
                break;
                
            case 2:
                Patient.searchPatient();
                break;
            case 3:
              showPatientList();
                break;
            case 4:
                leave();
                break;
            case 5:
                  new ReceptionistCalling().logout();
                break;
          
                  
        }
    }

    @Override
 

  
    public void logout() {
        Banner.clearScreen();
        Banner.showBanner();
         try {
             Banner.showHome();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ReceptionistCalling.class.getName()).log(Level.SEVERE, null, ex);
         } catch (Exception ex) {
             Logger.getLogger(ReceptionistCalling.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
}
