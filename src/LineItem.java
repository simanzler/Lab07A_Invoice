public class LineItem {
    int Quantity;
    Product Product;
    public LineItem(int quantity, Product product) {
        Quantity = quantity;
        Product = product;
    }
    public String getLineItem() {
        return Product.getName() + "               " + Quantity + "     " + Product.getPrice() + "     " + String.format( "%.2f", (Quantity*Product.getPrice())) + "\n";
    }
}
