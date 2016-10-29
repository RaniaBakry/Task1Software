
package tasksw;

import java.util.Scanner;


public class TaskSW {
    
        public static void main(String[] args) 
    {
         System.out.println(" 1 to Add , 2 to Delete , 3 to Update , 4 to Retrieve, 0 to End");
               
         int x=1;
         while (x<2){

        Scanner scan= new Scanner(System.in);
        int sw=scan.nextInt();
        
        switch(sw){
            case (1): //Insert Data     
         
		Product testpro = new Product();
		testpro.setProductID("12333");
		testpro.setProductType("Cars");
		testpro.setProductManufacturer("BMW");
		testpro.setProductProDate("2020-1-1");
		testpro.setProductExpirDate("2020-2-2");
		DAOimplement newtest = new DAOimplement();
		newtest.insert_product(testpro);
                
                
                break;
            case (2): //Delete Row By ID
                
                Product del = new Product();
		del.setProductID("1211");
		DAOimplement Delete = new DAOimplement();
		Delete.deleteProduct(del);
                
                break;
   
            case (3): //Update Row 
    
                Product Up = new Product();
		Up.setProductID("111111");
		Up.setProductType("Food");
		Up.setProductManufacturer("EDITA");
		Up.setProductProDate("2016-01-01");
		Up.setProductExpirDate("2016-02-02");
		DAOimplement Update = new DAOimplement();
		Update.updateProduct(Up);
        
               break;
   

           case (4): 
    
		DAOimplement Retrieve = new DAOimplement();
		Retrieve.listProducts("BMW");

             break;
           case (0):
               x++;
             System.out.print("Program Ended");
            
             break;
           default: 
                System.out.print("Invalid number");
                
                break;       
        
        } 
    }
      }
    

  
}


