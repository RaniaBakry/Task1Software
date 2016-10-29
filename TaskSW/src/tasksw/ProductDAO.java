
package tasksw;


import java.util.ArrayList;


public interface ProductDAO {
		public void insert_product(Product product);
		public void deleteProduct(Product productID);
                public ArrayList<Product> listProducts (String manufacturer);
                public void updateProduct(Product product);
               
}
