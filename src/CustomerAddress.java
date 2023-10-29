public class CustomerAddress {
    String Title;
    String Street;
    String State;
    String City;
    String Zip;
    public CustomerAddress(String title, String street, String state, String city, String zip){
        Title = title;
        Street = street;
        State = state;
        City = city;
        Zip = zip;
    }
    public String GetAddress(){
        return Title + "\n" + Street + "\n" + City + ", " + State + " " + Zip;
    }
}
