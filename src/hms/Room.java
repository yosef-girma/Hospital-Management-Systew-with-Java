
package hms;
import static hms.AdminCalling.showAdminDetail;


import java.io.File;

import java.io.PrintWriter;
import java.util.Scanner;

import static hms.Banner.promptChoice;

import static hms.Banner.showPharmacistsOption;
import static hms.ManageDoctor.operateDoctorChoice;
import static hms.ManageReception.operateReceptionChoice;
import static hms.FileEngine.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Room {

    
      private Room room_obj;
 
 
 private ArrayList<String> available_room_no=new ArrayList<>();
 
   private int roomNumber;
  public String type;
  private  String status;
  private  double price;
  
    public static void main(String[] args) {
        
      }

 public static void roomDetails() throws Exception
 {
     
     int menu_choice=new Room().roomOptionList();
  
     
            switch (menu_choice)
       {
        
           case 1: 
               
                  new Room(). manageRooms();
              
               break;
           case 2:
               
               new Room().availableRooms();
               break;
           case 3:
            viewAllRooms();
               break;
           case 4:
               
               showAdminDetail();
               break;
       }
     
     
 }

        public  static  int roomOptionList(){
       
       
        System.out.println("1.Add New rooms");
       
        System.out.println("2.Available rooms");       
       
         System.out.println("3.View All Rooms");
         
         System.out.println("4.back");
        
        return promptChoice();
    }
        public static void showRoomBanner()
        {
            
            System.out.println("-----------------------------------------------------------------------------  ");
        System.out.println(" Room-No                         Free                  Type               Price");
         System.out.println("-----------------------------------------------------------------------------  ");
            
        }
    public static  void viewAllRooms() throws Exception
    {
     
        showRoomBanner();
        
        Scanner readfile=new Scanner(new File("room_info.txt"));
        
      
      
        
        while(readfile.hasNext())
        {
         System.out.println(readfile.next()+"        "+readfile.next()+"    "+readfile.next()+"    "+readfile.next());    
         
            
        }
        
    readfile.close();
        
    }
  
    public static void backOption(String identifer) throws Exception 
    {
        switch(identifer)
        {
            
            case "room":
                roomDetails();
                break;
                
            case "doc":
               operateDoctorChoice();
                break;
            case "rec":
                operateReceptionChoice();
            break;
            case "med":
                showPharmacistsOption();
                break;
            
        }
    
    }
   public  void availableRooms() throws FileNotFoundException, Exception
    {
        showRoomBanner();
    
        Scanner readfile=new Scanner(new File("room_info.txt"));
        
        String room_no= readfile.next();
        String status=readfile.next();
        
        
        
        while(readfile.hasNext())
        {
            
          if(status.equals("open"))
          {
         
           
           
         System.out.println(room_no+"        "+status+"    "+readfile.next()+"    "+readfile.next());    
          }    
        }   
       
        backOption("room");
    }
     public    void manageRooms() throws Exception
     {
    Scanner input = new Scanner(System.in);
          room_obj=new Room();
          
   
        
        System.out.println("Room No");
        
       room_obj.roomNumber=input.nextInt();
        
        
         System.out.println("Level");
        
         
         room_obj.type=input.next();
         
         
         
          System.out.println("Price");
         
         room_obj.price=input.nextDouble();
        
          try
          {
           saveFile();
          }
          catch(Exception exception)
          {
              exception.printStackTrace();
          }
    
       backOption("room");
     
     }
     public  void saveFile() throws Exception
    {
   String filename=new String("room_info.txt");
        
        
       
        PrintWriter pwriter=writer(filename);
        pwriter.println(room_obj.roomNumber+"   "+room_obj.status+"   "+room_obj.type+"   "+room_obj.price);
        
        pwriter.close();
            
}
     
  
     public  String checkRoomAvaliablity() throws FileNotFoundException
     {
         
         Scanner readfile=new Scanner(new File("room_info.txt"));
        
        String room_no= readfile.next();
        String status=readfile.next();   
        while(readfile.hasNextLine())
        {  
          if(status.equals("open"))
          {
           available_room_no.add(room_no);
          }
              
        }
       return available_room_no.get(new Random().nextInt(available_room_no.size())); 
       
}


}


    

