/**
* Creates an array of Vaccine objects
* @author Omolemo Modise
* @version 1.0
*/
public class VaccineArray{
    
    Vaccine[] data = new Vaccine[9919];
    int records = 0;
    /**
    * @param vac adds the Vaccine objects to the array called data[]
    */
    public void addData (Vaccine vac){
        
        data[records] = vac;
        records++; 
    }
    /**
    * @returns Returns amount of data stored 
    */
    public int getRecords (){
        return records;
    }
    
}
