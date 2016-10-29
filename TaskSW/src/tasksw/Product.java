
package tasksw;


public class Product {
    
	private String ProductID;
	private String ProductType;
	private String ProductManufacturer;
	private String ProductProDate;
	private String ProductExpirDate;
	
	
	public void setProductID(String ProductID){
		this.ProductID = ProductID;
	}
	
	
	public void setProductType(String ProductType){
		this.ProductType = ProductType;
	}
	
	public void setProductManufacturer(String ProductManufacturer){
		this.ProductManufacturer = ProductManufacturer;
	}
	
	public void setProductProDate(String ProductProDate){
		this.ProductProDate = ProductProDate;
	}
	
	public void setProductExpirDate(String ProductExpirDate){
		this.ProductExpirDate = ProductExpirDate;
	}
	
	
	public String getProductID(){
		return(this.ProductID);
	}
	
	
	public String getProductType(){
		return(this.ProductType);
	}
	
	
	public String getProductManufacturer(){
		return(this.ProductManufacturer);
	}
	
	
	public String getProductProDate(){
		return(this.ProductProDate);
	}
	
	public String getProductExpirDate(){
		return(this.ProductExpirDate);
	}

    void setString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	

}
