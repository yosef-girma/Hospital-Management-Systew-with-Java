
package hms;

import java.util.Scanner;

import static hms.Banner.*;


import java.io.FileNotFoundException;

public class Main
{
    
    
    public Scanner input;
    
    
    public static void main(String []args) throws FileNotFoundException, Exception
    {
        
        Banner.showBanner();
        
        showHomeDetail(Banner.showHome());
        
        
        
    }
    public static void showHomeDetail(int choice) throws FileNotFoundException, Exception
    {
        
        if(choice<0 || choice >5)
        {
            clearScreen();
            showHome();
            
        }
        
        switch(choice)
        {
            
            case 1:
                
            {
                clearScreen();
                showBanner();
                makeGap();
                
                makeGap();
                showAdminOptions();
            }
            
            
            
            
            break;
            case 2:
            {
                clearScreen();
                showBanner();
                makeGap();
                showDoctorOption();
            }
            
            
            
            
            
            makeGap();
            
            break;
            case 3:
                
                
                
                
                showPharmacistsOption();
                
                
                
                clearScreen();
                showBanner();
                makeGap();
                
                
                
                
                
                break;
            case 4:
                
                
                showReceptionistOption();
                
                
                
                
                clearScreen();
                showBanner();
                makeGap();
                
                makeGap();
                break;
            case 5:
                
                System.exit(0);
                break;
        }
        
    }
}
