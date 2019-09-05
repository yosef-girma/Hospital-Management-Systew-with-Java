
package hms;

import static hms.Banner.print;
import static hms.Banner.println;
import static hms.Banner.*;
import static hms.AdminCalling.*;
import static hms.Patient.input;
import static hms.Room.backOption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Scanner;
import java.time.LocalDate;

public class ManageDoctor
{
    
    static protected String firstName;
    static  protected String lastName ;
    static protected String specialization  ;
    static  protected int experience;
    static  protected String userid;
    static protected int age;
    static protected LocalDate date=LocalDate.now();
    public static ManageDoctor doctor;
    
    public static  Scanner scan;
    
    public static void operateDoctorChoice() throws Exception
    {
        
        ManageDoctorOption();
        int doc_choice=promptChoice();
        switch(doc_choice)
        {
            case 1:
                registerDoctor();
                break;
                
                
            case 2:
                searchDoctor();
            case 3:
                showRegisteredDoctor();
                break;
            case 4:
                String id_=confirm();
                deleteFromFile(id_);
                break;
            case 5:
                showAdminOptions();
                break;
        }
        
    }
    
    public static void ManageDoctorOption()
    {
        
        
        out.println("\n                    [1] ->Register a Doctor");
        
        out.println("                    [2] ->  Search Doctor");
        out.println("                    [3] ->  List Registered Doctors");
        
        out.println("                     [4] -> Delete Doctor Info");
        out.println("                     [5]  -> back");
    }
    
    public static void registerDoctor() throws Exception {
        
        String fileName="doctor_info.txt";
        
        doctor=new ManageDoctor();
        
        scan = scanner();
        
        println("-----------------------------------------");
        println("********** ENTER DOCTOR DETAILS *********");
        println("-----------------------------------------");
        print("|  User Id : 			| 		");
        doctor.userid = scan.next();
        println("-------------------------------------------------------------------");
        println("-------------------------------------------------------------------");
        print("|  First name : 		| 		");
        doctor.firstName = scan.next();
        println("-------------------------------------------------------------------");
        print("|  Last name  : 		| 		");
        doctor.lastName = scan.next();
        println("-------------------------------------------------------------------");
        print("|  Specialization : 		| 		");
        doctor.specialization = scan.next();
        println("-------------------------------------------------------------------");
        print("|  Experience (int) : 		| 		");
        doctor.experience = scan.nextInt();
        println("-------------------------------------------------------------------");
        
        print("|  Age (int) :	 		| 		");
        doctor.age = scan.nextInt();
        println("-------------------------------------------------------------------\n");
        
        new  StoreDoctor().storeDoctorData(doctor, fileName);
        
        backOption("doc");
        
    }
    
    public static void showRegisteredDoctor() throws FileNotFoundException, Exception
    {
        
        File fileee=new File("doctor_info.txt");
        Scanner reader=new Scanner(fileee);
        
        clearScreen();
        showDoctorBanner();
        
        while(reader.hasNext())
        {
            
            
            System.out.println(
                    reader.next()+"         "+
                            "Dr." +   reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()
                            +"      "+reader.next());
            
            
            
            
            
        }
        
        
        reader.close();
        
        
        backOption("doc");
    }
    
    
    public static void searchDoctor() throws FileNotFoundException, Exception
    {
        
        
        
        
        System.out.print("Enter Doctor Id:-");
        String  doctor_id=input.next();
        
        
        File file=new File("doctor_info.txt");
        
        Scanner reader=new Scanner(file);
        boolean found=false;
        
        while(reader.hasNext())
        {
            
            
            
            if(doctor_id.equals(reader.next()))
                
            {
                found=true;
                
                System.out.println(" Name : "+ " "+ "Dr."+reader.next()+" "+reader.next());
                
                
                
                
                System.out.println( "Specialization:-"+" "+reader.next());
                
                System.out.println( "Experience:-"+" "+reader.next());
                System.out.println( "Age:-"+" "+reader.next() );
                System.out.println( "Registration Date:-  "+" "+reader.next() );
                
            }
            
            
            
            
        }
        reader.close();
        if(!found)
            System.out.println("NO Doctor is Found assosicated with the id");
        
        
        backOption("doc");
    }
    
    
    public static void deleteFromFile(String myid) throws Exception
    {
        
        
        boolean found=true;
        String id=myid;
        System.out.println(id);
        
        
        String new_filename="temp.txt";
        String old_file_path="doctor_info.txt";
        File old_file=new File(old_file_path);
        
        
        File new_file=new File(new_filename);
        FileWriter fwriter=new FileWriter(new_file,true);
        BufferedWriter bw=new BufferedWriter(fwriter);
        PrintWriter pwriter=new PrintWriter(bw);
        
        Scanner reader=new Scanner(old_file);
        
        
        while(reader.hasNext())
            
            
        {
            
            String mid=reader.next();
            String fname=reader.next();
            
            String lname=reader.next();
            String s=reader.next();
            
            String e=reader.next();
            
            String a=reader.next();
            String d=reader.next();
            
            if(id.equals(mid))
                
            {
                
                
                
            }
            
            else
            {
                found=true;
                pwriter.println(mid+"   "+
                        fname+"   "+lname+"  "+s+"  "+e+"  "+"    "+
                        a+"   "+d
                );
                
            }
            
            
            
            
            
        }
        
        
        
        
        reader.close();
        pwriter.flush();
        pwriter.close();
        
        
        
        
        old_file.delete();
        
        File myfile=new File(old_file_path);
        new_file.renameTo(myfile);
        if(found==true)
        {  System.out.println("DELETE SUCCEFULLY");
        }
        
        
        backOption("doc");
        
        
    }
}

