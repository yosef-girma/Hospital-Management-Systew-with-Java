
package hms;

import static hms.AdminCalling.confirm;
import static hms.Banner.*;
import static hms.Medicine.deleteMedicine;
import static hms.Medicine.searchMedicine;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PharmacisitCalling implements CommonInterface{
    
    
    static Scanner  input=new Scanner(System.in);
    
     public static String getId() throws FileNotFoundException, Exception
     {
         
         System.out.println("Enter the Id");
      
         String myid=input.next();
         searchMedicine(myid);
         return myid;
     }
       public static String getAmount()
     {
         
            System.out.println("Amount of Medicine");
             String amt =input.next();      
         return amt;
     }
          public static String getPrice()
     {
           System.out.println("Price of Medicine");
             String price=input.next();
         
         return price;
     }
public  static void showPharmacisitDetail() throws FileNotFoundException, Exception
{
   
    int choice=promptChoice();
      switch(choice)
   {
       
       case 1:
          Medicine.addNewMedicine();
           break;
        case 2:
          
            Medicine.searchMedicine();
            
           break;
        case 3:
          
             Medicine.updateMedicine();
           break;
           
        case 4:
            String id=confirm();
            deleteMedicine(id);
            break;
        case 5:
        Medicine.showMedicineList();
            break;
        case 6:
           new PharmacisitCalling().logout();
               break;
            
   
                    
   
      }   
}

    @Override
    public boolean login() {



   return true;
    }

    @Override
    public void logout() {
        Banner.clearScreen();
        Banner.showBanner();
    try {
        Banner.showHome();
    } catch (Exception ex) {
        Logger.getLogger(PharmacisitCalling.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
       
}
