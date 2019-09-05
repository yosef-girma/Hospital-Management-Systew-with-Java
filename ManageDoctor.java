/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editodoctor.
*/


/*import static hospitalpackag.BannerMainClass.print;
import static hospitalpackag.BannerMainClass.println;
import static hospitalpackag.BannerMainClass.*;
import static hospitalpackag.Patient.input;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
/**
 *
 * @author pc
 */

import java.io.*;
import java.util.*;
public class ManageDoctor
{
    
    static String firstName;
    static String lastName ;
    static String specialization  ;
    static int experience;
    static String userid;
    static int age;
    
    
   // static  LocalDate date=LocalDate.now();
    public static ManageDoctor doctor;
    
    
    
    public static void main(String[] args) throws Exception
    {
    	
    	Scanner scan=new Scanner(System.in);
    	deleteFromFile(scan.next());
    	
    	
    }
   // public static  Scanner scan;
    
    
    /*
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
        
        showAdminOptions();
    }
    */
    
    public static void doctorBanner()
    {
        
        
        
        
    }
    
    /*
    public static void showRegisteredDoctor() throws FileNotFoundException, Exception
    {
        
        File file=new File("doctor_info.txt");
        Scanner reader=new Scanner(file);
        
       // clearScreen();
        //showDoctorBanner();
        
        while(reader.hasNext())
        {
            
            
            System.out.println(
                    reader.next()+"         "+
                            "Dr." +   reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()
                            +"      "+reader.next()+
                            "      "+reader.next());
            
            
            
            
            
        }
        
        
        reader.close();
      //  showAdminOptions();
        
    }
    
    */
    /*
    
    public static void searchDoctor(String id) throws FileNotFoundException
    {
        
        
        
        
        System.out.println("Enter Doctor Id");
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
                
                
                
                
                System.out.println( "Specialization "+" "+reader.next());
                
                System.out.println( "Experience "+" "+reader.next());
                System.out.println( "Age"+" "+reader.next() );
                System.out.println( "Registration Date  "+" "+reader.next() );
                
            }
            
            
            
            
        }
        reader.close();
        if(found)
            System.out.println("NO Medcine Found assosicated with the id");
        
    }
    
    */
    
    
    public static void deleteDoctor() throws FileNotFoundException, Exception
    {
        
    	Scanner scan=new Scanner(System.in);
        System.out.println("Enter the doctor id to be deleted");
        
        String doctor_id=scan.next();
        
        //searchDoctor(doctor_id);
        
        
        
        System.out.println("Are you sure you want delete the record(Y/N)");
        
        /*
        Srconfirm;
        
        confirm=input.next();
        if(confirm=='y'|| confirm=='Y')
        {
            
        
            
        }
        
        */
            //deleteFromFile(doctor_id);
        
        
    }
    
    public static void deleteFromFile(String myid) throws Exception
    {
    	Scanner g=new Scanner(System.in);
    	String id=myid;
    	g.close();
        System.out.println(id);
        
        
        String new_filename="temp.txt";
        String old_file_path="doctor_info.txt";
        File old_file=new File(old_file_path);
        
        
        File new_file=new File(new_filename);
        FileWriter fwriter=new FileWriter(new_file,true);
        BufferedWriter bw=new BufferedWriter(fwriter);
        PrintWriter pwriter=new PrintWriter(bw);
        
        Scanner reader=new Scanner(old_file);
        
        //reader.useDelimiter("[,\n]");
        while(reader.hasNext())
            
            
        {
            
        	   String mid=reader.next();
            String fname=reader.next();
              System.out.println(fname);
            String lname=reader.next();
            String s=reader.next();
              System.out.println(s);
         String e=reader.next();
          System.out.println(e);
            String a=reader.next();
            String d=reader.next();
          
        
        	
            
          //  String file_id=reader.next();
            if(id.equals(mid))
            	
            {
                
                
        
                
        
          
             
            }
        
            else
            {
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
        
        
        
        
        
        
        
    }
    
        
        
        
    }

