/**
* Creates a Vaccine object to store information about the vaccinations of a Country on a specific date
* @author Omolemo Modise
* @Version 1.0
*/
public class Vaccine 
{
    
    String country;
    String date;
    String vaccinations;
    
    /**
    * @param line accepts the line with data e.g "Bermuda,2022-01-15,118" and sets the instant variables
    */
    public Vaccine(String line){
        
        String[] info = line.split (",");
        country = info[0];
        date = info[1];
        if (info.length == 3){
            vaccinations = info[2];
        }else{
            vaccinations = null;
        }
    }
    
    /**
    * @param other accepts the Vaccine object and compare it to this object
    */
    public  int compareTo(Vaccine other){
    	return (country.compareTo(other.country) +date.compareTo(other.date));
    }
}

