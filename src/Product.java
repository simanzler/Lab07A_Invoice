import javax.naming.Name;

public class Product {
    String Name;
    Double Price;
    public Product(String name, double price){
        Name = name;
        Price = price;
    }
    public String getName() {
        return Name;
    }
    public Double getPrice() {
        return Price;
    }
}
