
package tasksw;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOimplement implements ProductDAO{
    

        @Override
	public void insert_product(Product product){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product", "root", "");
                        
                        // the mysql insert statement
                          String query = " INSERT INTO equipments (ProductID, ProductType, ProductManufacturer, ProductProDate, ProductExpirDate)"
                           + " values (?, ?, ?, ?, ?)";
                        
                          
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, product.getProductID());
			psmt.setString(2, product.getProductType());
			psmt.setString(3, product.getProductManufacturer());
			psmt.setString(4, product.getProductProDate());
			psmt.setString(5, product.getProductExpirDate());
			int i = psmt.executeUpdate();
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Product was successfully added");
			}
			else {
				JOptionPane.showMessageDialog(null, "Product was not added");
			}
		}
		catch (ClassNotFoundException | SQLException | HeadlessException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
    @Override
	public void deleteProduct(Product productId)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
                        
                        String query = "DELETE FROM equipments WHERE ProductID=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, productId.getProductID());
                        
			int rowsUpdated = psmt.executeUpdate();
			if (rowsUpdated == 0) {
				JOptionPane.showMessageDialog(null, "User does not exist");
			} else {
				JOptionPane.showMessageDialog(null, "User deleted");
			}
			
			}
		 catch (ClassNotFoundException | SQLException | HeadlessException e)
		 {
			 JOptionPane.showMessageDialog(null, e); 
		 }
		 }
        
        
    @Override
        public void updateProduct(Product product)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
			PreparedStatement psmt = conn.prepareStatement("UPDATE equipments SET Type=?,Manufacturer=?,ProductionDate=?,ExpiryDate=? WHERE ProductID=?");
	
			psmt.setString(1, product.getProductID());
			psmt.setString(2, product.getProductType());
			psmt.setString(3, product.getProductManufacturer());
			psmt.setString(4, product.getProductProDate());
			psmt.setString(5, product.getProductExpirDate());
                        
                        int rowsUpdated = psmt.executeUpdate();
			if (rowsUpdated == 0) {
				JOptionPane.showMessageDialog(null, "Update done");
			} else {
				JOptionPane.showMessageDialog(null, "EMPTY");
			}
                        }
			catch (ClassNotFoundException | SQLException | HeadlessException e)
			 {
				 JOptionPane.showMessageDialog(null, e); 
			 }
			
			

	}
        
           
        
    @Override
       public ArrayList<Product> listProducts (String manufacturer) 
                
	{
              ArrayList<Product> prod = new ArrayList<>();
               Product product = null;
            try 
            {
              
               
		        Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
			
                        
                        String query = "SELECT * FROM `equipments` WHERE `Manufacturer` LIKE '"+ manufacturer +"' ";
                       
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        
                           while (rs.next())
                  {  
                      
                    int numColumns = rs.getMetaData().getColumnCount();
                 
                   
                    
                    String ProductID= (rs.getString("ProductID"));
                    String ProductType = rs.getString("ProductType");
                    String ProductManufacturer = rs.getString("ProductManufacturer");
                    String ProductProDate = rs.getString("ProductProDate");
                    String ProductExpirDate = rs.getString("ProductExpirDate");
                      
                   

                     //Display values
                    System.out.print("ProductID: " + ProductID);
                    System.out.print(", ProductType: " + ProductType);
                    System.out.print(", ProductManufacturer: "+ ProductManufacturer);
                    System.out.print(", ProductProDate: " + ProductProDate);
                    System.out.println(", ProductExpirDate: "+ ProductExpirDate);
                    
                    prod.add(product);
                   
               
                 
                }
			
                        rs.close();
                        
        }
            
            catch (SQLException e) {
                System.out.print("Failed to find products");
			JOptionPane.showMessageDialog(null, e);
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
            return prod;

	}
                
}		
