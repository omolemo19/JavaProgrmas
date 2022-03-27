/**
* Application for the AVLTree experiment
* @author Omolemo Modise
* @version 1.0
*/
import java.io.*;
import java.util.*;

public class AVLExperiment{
    
    
    
    
    
    public static void main(String[] args){
        
       VaccineArray vacAr = new VaccineArray();
       File fl = new File ("src/vaccinations.csv");
       
       //Read in data from a file and add to an array
       try {
          Scanner sc = new Scanner(fl);
       
          while (sc.hasNextLine()){
              String line = sc.nextLine();
              vacAr.addData(new Vaccine(line));
          } 
       } catch (FileNotFoundException e){
            System.out.println("File Not Found.");
         }
        
        AVLTree<String> tree = new AVLTree<String>();
        //Randomize the array with the data(straight from file)   
        int arrLen = vacAr.data.length;
        for( int i = 0; i < (arrLen)/Integer.parseInt(args[0]); i++){
            
            int k = i + (int)( Math.random()*(arrLen -i));
            Vaccine temp = vacAr.data[k];
            vacAr.data[k] = vacAr.data[i];
            vacAr.data[i] = temp;
   
        }
        
        //Remove Duplicates in randomized array
        int len = vacAr.data.length;
        int j = 0;
        
        for (int t = 0; t < len-1; t++){
            if (vacAr.data[t] != vacAr.data[t+1]){
            	vacAr.data[j++] = vacAr.data[t];
            }
        }
        
        vacAr.data[j++] = vacAr.data[len -1];
        
        int count = vacAr.data.length;//used below 
        System.out.println("INSERTING");
        
        //"insert" randomized data into AVLTree 
        String[] insertedData = new String[3];
        int x;
        for (x = 0; x < count ; x++){
            if (vacAr.data[x].vaccinations == null){
                String vaccine = vacAr.data[x].country+","+vacAr.data[x].date;
                tree.insert(vaccine);
                
                
                if (x == 0){
                   System.out.println(vaccine);
                   System.out.println("Minimum Operations: "+tree.getInOp());
                   System.out.println("");
                   insertedData[0] = vaccine;
                   tree.resetInOp();
               
                }else if(x == (count-1)/2){
                    System.out.println(vaccine);
                    System.out.println("Average Operations: "+tree.getInOp());
                    System.out.println("");
                    insertedData[1] = vaccine;
                    tree.resetInOp();
                    
                 }else if(x == count-1){
                     System.out.println(vaccine);
                     System.out.println("Maximum Operations: "+tree.getInOp());
                     System.out.println("");
                     insertedData[2] = vaccine;
                     tree.resetInOp();
                     break;
                  }else {
                      tree.resetInOp();
                  }
            }else {
                String vaccine = vacAr.data[x].country+","+vacAr.data[x].date+","+vacAr.data[x].vaccinations;
                tree.insert(vaccine);
                
                if (x == 0){
                   System.out.println(vaccine);
                   System.out.println("Minimum Operations: "+tree.getInOp());
                   System.out.println("");
                   insertedData[0] = vaccine;
                   tree.resetInOp();
               
                }else if(x == (count-1)/2){
                    System.out.println(vaccine);
                    System.out.println("Average Operations: "+tree.getInOp());
                    System.out.println("");
                    insertedData[1] = vaccine;
                    tree.resetInOp();
                 
                 }else if(x == count-1){
                     System.out.println(vaccine);
                     System.out.println("Maximum Operations: "+tree.getInOp());
                     System.out.println("");
                     insertedData[2] = vaccine;
                     tree.resetInOp();
                     break;
                  }            
             
             }    
        }
        
        //"find" the data inserted from the AVLtree
        System.out.println("FINDING");
        
        int d;
        for (d =0; d< count; d++){
            BinaryTreeNode<String> nodeReturn;
            if (vacAr.data[d].vaccinations == null){
             nodeReturn = tree.find(vacAr.data[d].country+","+vacAr.data[d].date);
            
            if (d == 0){
               System.out.println(vacAr.data[d].country+","+vacAr.data[d].date);
            	System.out.println("Minimum Operations: "+tree.getFdOp());
            	System.out.println("");
            
            }else if (d == (count-1)/2){
            System.out.println(vacAr.data[d].country+","+vacAr.data[d].date);
            System.out.println("Average Operations: "+tree.getFdOp());
            System.out.println("");
             
             }else if (d == count -1){
            System.out.println(vacAr.data[d].country+","+vacAr.data[d].date);
              	  System.out.println("Maximum Operations: "+tree.getFdOp());
              	  System.out.println("");
              
              }else {
                   tree.resetFdOp();
               }
              
            }else {
                nodeReturn = tree.find(vacAr.data[d].country+","+vacAr.data[d].date+","+vacAr.data[d].vaccinations);
            
            if (d == 0){
        System.out.println(vacAr.data[d].country+","+vacAr.data[d].date+","+vacAr.data[d].vaccinations);
            	System.out.println("Minimum Operations: "+tree.getFdOp());
            	System.out.println("");
            	tree.resetFdOp();
            
            }else if (d == (count-1)/2){
            	 System.out.println(vacAr.data[d].country+","+vacAr.data[d].date+","+vacAr.data[d].vaccinations);
            	 System.out.println("Average Operations: "+tree.getFdOp());
            	 System.out.println("");
            	 tree.resetFdOp();
             
             }else if (d == count -1){
              	  System.out.println(vacAr.data[d].country+","+vacAr.data[d].date+","+vacAr.data[d].vaccinations);
              	  System.out.println("Maximum Operations: "+tree.getFdOp());
              	  System.out.println("");
              	  tree.resetFdOp();
              }else {
              	   tree.resetFdOp();
              }
               
               }
         }
            
        }
}