
package hms;


import static hms.AdminCalling.confirm;
import static hms.Banner.print;
import static hms.Banner.println;
import static hms.Banner.*;
import static hms.Patient.input;
import static hms.Room.backOption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.time.LocalDate;

import java.util.Scanner;


public class ManageReception
{
    
    static String firstName;
    
    static         String lastName;
    
    static int experience;
    static  String userid;
    
    static   int age;
    
    static LocalDate date=LocalDate.now();
    public  static ManageReception receptionist;
    
    public static void operateReceptionChoice() throws FileNotFoundException, Exception
    {
        manageReceptionistOption();
        
        int recp_choice=promptChoice();
        switch(recp_choice)
        {
            
            case 1:
                addReceptionist();
                break;
                
            case 2:
                searchReceptionist();
                break;
                
            case 3:
                showReceptionistList();
                break;
                
            case 4:
                
                
                
                String u_id=confirm();
                deleteReceptionist(u_id);
                break;
                
            case 5:
                showAdminOptions();
                break;
                //back
                
        }
    }
    public static void manageReceptionistOption()
    {
        
        
        out.println("                    [1] -> Add Receptionist");
        out.println("                    [2] -> Search Receptionist");
        out.println("                    [3] -> List Receptionists");
        out.println("                    [4] -> Delete Receptionist");
        out.println("                [5] -> back");
        
        
        
    }
    public static void addReceptionist() throws Exception
            
    {
        Scanner scan=new Scanner(System.in);
        String filename="Receptionist.txt";
        receptionist=new ManageReception();
        
        println("-----------------------------------------");
        println("********** ENTER Reception DETAILS *********");
        println("-----------------------------------------");
        
        print("|  User Id : 			| 		");
        receptionist.userid = scan.next();
        println("-------------------------------------------------------------------");
        println("-------------------------------------------------------------------");
        print("|  First name : 		| 		");
        receptionist.firstName = scan.next();
        println("-------------------------------------------------------------------");
        print("|  Last name  : 		| 		");
        receptionist.lastName= scan.next();
        println("-------------------------------------------------------------------");
        print("|  Experience (int) : 		| 		");
        receptionist.experience= scan.nextInt();
        println("-------------------------------------------------------------------");
        
        print("|  Age (int) :	 		| 		");
        receptionist.age = scan.nextInt();
        println("-------------------------------------------------------------------\n");
        
        new   Receptionist_Store().storeReceptionist(receptionist, filename);
        // showReceptionistOption();
        
        backOption("rec");
    }
    
    public static void searchReceptionist() throws FileNotFoundException, Exception
    {
        
        
        System.out.print("Enter Receptionist Id:-");
        String  reception_id=input.next();
        
        
        File filee=new File("Receptionist.txt");
        
        Scanner reader=new Scanner(filee);
        boolean found=false;
        
        while(reader.hasNext())
        {
            
            
            
            if(reception_id.equals(reader.next()))
                
            {
                found=true;
                
                System.out.println(" Name :-"+reader.next()+" "+reader.next());
                System.out.println( "Age:-"+" "+reader.next() );
                System.out.println( "Experience:- "+" "+reader.next());
                System.out.println( "Registration Date:-  "+" "+reader.next() );
                
            }
            
            
            
            
        }
        reader.close();
        if(!found)
            System.out.println("NO Receptionist is Found assosicated with the id");
        
        backOption("rec");
    }
    
    
    public static void deleteReceptionist(String recp_id) throws IOException, Exception
            
    {
        
        
        
        String id;
        String new_filename="temp.txt";
        String old_file_path="Receptionist.txt";
        File old_file=new File(old_file_path);
        
        
        File new_file=new File(new_filename);
        
        
        PrintWriter pwriter=new PrintWriter(new BufferedWriter(new FileWriter(new_file,true)));
        
        Scanner reader=new Scanner(old_file);
        
        
        while(reader.hasNext())
            
            
        {
            
            id=reader.next();
            String fname=reader.next();
            
            String lname=reader.next();
            
            
            String exp=reader.next();
            
            String age=reader.next();
            String date=reader.next();
            
            
            
            
            
            if(id.equals(recp_id))
            {
                
                
            }
            else
            {
                pwriter.println(id+"   "+
                        fname+"   "+lname+"  "+exp+"  "+"    "+
                        age+"   "+ date
                );
                System.out.println("Delete successufully");
            }
        }
        
        reader.close();
        pwriter.flush();
        pwriter.close();
        
        old_file.delete();
        
        File myfile=new File(old_file_path);
        new_file.renameTo(myfile);
        
        backOption("rec");
        
    }
    public static void showReceptionistList() throws FileNotFoundException, Exception
    {
        
        
        
        
        File file=new File("Receptionist.txt");
        
        Scanner reader=new Scanner(file);
        
        
        showReceptionistBanner();
        while(reader.hasNext())
        {
            
            
            System.out.println(
                    reader.next()+"         "+
                            reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()
                    
            );
            
            
            
            
            
        }
        
        
        reader.close();
        
        backOption("rec");
    }
    
}
