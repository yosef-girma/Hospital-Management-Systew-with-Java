
package hms;

import java.io.PrintWriter;
import static hms.FileEngine.writer;
public class StoreMedicine {
    
    
    
    public static void storeMedicineData(Medicine med_item) throws Exception
    {
        
        String fileName="medicine_store.txt";
        
        PrintWriter pwriter=writer(fileName);
        
        pwriter.println(
                
                med_item.medicine_id + "  "+
                        med_item.medicine_name + "  "+
                        med_item.category + "  "+
                        med_item.amount + "  "+
                        med_item.price + "  "+
                        med_item.localdate + "  "
                
                
        );
        pwriter.flush();
        pwriter.close();
        
    }
    
}
