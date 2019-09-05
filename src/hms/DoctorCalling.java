
package hms;


import static hms.Banner.*;
import static hms.DiagonsisReport.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorCalling  implements CommonInterface
{
    
    
    public  static void showDoctorDetail() throws Exception
    {
        
        
        int choice=promptChoice();
        
        switch(choice)
        {
            
            case 1:
                
                patientInfo();
                break;
                
            case 2:
                patientDiagonsisReport();
                break;
            case 3:
                new DoctorCalling().logout();
                break;
            default:
                
                
        }
        
    }
    
    @Override
    public boolean login()
    {
        
        return true;
    }
    
    @Override
    public void logout() {
        Banner.clearScreen();
        Banner.showBanner();
        try {
            Banner.showHome();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorCalling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DoctorCalling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
