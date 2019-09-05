
package hms;

import static hms.Banner.clearScreen;
import static hms.Banner.*;
import static hms.Room.backOption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Medicine
{
    
    static Scanner input = new Scanner(System.in);
    
    
    static int medicine_id;
    static String medicine_name;
    static String category;
    static int exp_day;
    static int exp_month;
    static int exp_year;
    static int amount;
    static double price;
    static LocalDate localdate;
    static Medicine item_medicine;
    
    public static void addNewMedicine()  throws Exception{
        
        
        System.out.println("Enter Medicine ID");
        item_medicine.medicine_id=input.nextInt();
        System.out.println("Medicine Name : ");
        item_medicine.medicine_name = input.next();
        System.out.println("Enter the category of medicine");
        item_medicine.category=input.next();
        System.out.println("Enter the expiredate by day,month,year respectivly");
        exp_day= input.nextInt();
        exp_month=input.nextInt();
        exp_year=input.nextInt();
        
        item_medicine.localdate=LocalDate.of(exp_year, exp_month, exp_day);
        
        System.out.println("Enter the amount: ");
        item_medicine.amount=input.nextInt();
        System.out.println("Enter the price: ");
        item_medicine.price=input.nextDouble();
        
        new StoreMedicine().storeMedicineData(item_medicine);
        
        backOption("med");
        
        
    }
    public static  void showMedicineList() throws FileNotFoundException, Exception
    {
        
        
        File file=new File("medicine_store.txt");
        Scanner reader=new Scanner(file);
        
        clearScreen();
        
        showPharmacyBanner();
        while(reader.hasNext())
        {
            
            
            System.out.println(
                    reader.next()+"         " +
                            reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()+
                            "      "+reader.next()
                    
            );
            
            
            
            
            
        }
        
        
        reader.close();
        
        backOption("med");
    }
    
    
    
    public static void updateMedicine() throws Exception
    {
        
        
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Id:-");
        String med_id=scan.next();
        System.out.println("Enter Amount to update");
        String amount=scan.next();
        System.out.println("Enter Price to update");
        String med_price=scan.next();
        
        
        String new_filename="tempp.txt";
        String old_file_path="medicine_store.txt";
        File old_file=new File(old_file_path);
        
        File new_file=new File(new_filename);
        
        PrintWriter pwriter=new PrintWriter(new BufferedWriter(new FileWriter(new_file,true)));
        
        Scanner reader=new Scanner(old_file);
        
        
        while(reader.hasNext())
            
        {
            
            String mid=reader.next();
            String name=reader.next();
            
            String category=reader.next();
            
            String amt=reader.next();
            
            String price=reader.next();
            
            String exp_date=reader.next();
            
            
            if(!mid.equals(med_id))
                
            {
                
                pwriter.println(mid+"   "+           name+"   "+category+"  "+amt+"  "+price+"  "+
                        exp_date+"   "
                );
            }
            else
            {
                
                
                
                pwriter.println(mid+"   "+           name+"   "+category+"  "+amount+"  "+med_price+"  "+
                        exp_date+"   "
                );
                
            }
            
        }
        
        
        
        
        
        reader.close();
        pwriter.flush();
        pwriter.close();
        old_file.delete();
        File myfile=new File(old_file_path);
        new_file.renameTo(myfile);
        
        backOption("med");
        
    }
    public static void searchMedicine() throws FileNotFoundException, Exception
    {
        
        System.out.println("Please enter the id of medicine");
        String  med_id=input.next();
        
        searchMedicine(med_id);
        
        
        backOption("med");
    }
    
    public static void searchMedicine(String med_id) throws FileNotFoundException, Exception
    {
        
        
        
        
        File file=new File("medicine_store.txt");
        Scanner reader=new Scanner(file);
        boolean found=false;
        
        while(reader.hasNext())
        {
            
            
            
            if(med_id.equals(reader.next()))
                
            {
                found=true;
                System.out.println("Medicine Name :- "+" "+reader.next());
                System.out.println( "Category:-  " +reader.next());
                
                System.out.println( " Price:-  "+" "+reader.next() );
                
                System.out.println( "Amount:-  "+" "+reader.next() );
                
                
                System.out.println( "Expired-Date:-"+" "+reader.next() );
                
            }}
        if(!found)
        {
            System.out.println("NO Such Medicine Found");
        }
        
        backOption("med");
    }
    
    
    public static void deleteMedicine(String med_id) throws IOException, Exception
    {
        
        String new_filename="temp.txt";
        String old_file_path="medicine_store.txt";
        File old_file=new File(old_file_path);
        
        File new_file=new File(new_filename);
        
        PrintWriter pwriter=new PrintWriter(new BufferedWriter(new FileWriter(new_file,true)));
        
        Scanner reader=new Scanner(old_file);
        
        while(reader.hasNext())
            
        {
            
            String mid=reader.next();
            String name=reader.next();
            
            String category=reader.next();
            
            String amt=reader.next();
            
            String price=reader.next();
            
            String exp_date=reader.next();
            
            if(!mid.equals(med_id))
                
            {
                
                pwriter.println(mid+"   "+           name+"   "+category+"  "+amt+"  "+price+"  "+
                        exp_date+"   "
                );
            }
            else
                
            {
                amt="1000";
                price="1200";
                
                pwriter.println(mid+"   "+           name+"   "+category+"  "+amt+"  "+price+"  "+
                        exp_date+"   "
                );
            }
            
        }
        
        
        reader.close();
        pwriter.flush();
        pwriter.close();
        old_file.delete();
        File myfile=new File(old_file_path);
        new_file.renameTo(myfile);
        System.out.println("DELETE SUCCESSFULLY");
        
        backOption("med");
        
    }
    
}
