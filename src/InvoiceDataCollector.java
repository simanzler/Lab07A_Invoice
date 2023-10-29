import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceDataCollector extends JFrame {
    JPanel mainPnl;
    JTextArea textArea;
    JLabel question;
    int questionCount = 0;
    JTextArea answer;
    JButton add;
    JButton done;

    String title;
    String street;
    String state;
    String city;
    String zip;
    CustomerAddress address;

    String pName;
    double pPrice;

    int quantity;
    Product product;

    LineItem lineItem;

    double amountDue = 0;
    public InvoiceDataCollector(){
        mainPnl = new JPanel();
        question = new JLabel("Enter the title of the Invoice");
        answer = new JTextArea(1,20);
        add = new JButton("Add");
        done = new JButton("Done");
        textArea = new JTextArea(10,40);

        add.addActionListener((ActionEvent ae) -> {
            if (questionCount==0){
                title = answer.getText();
                answer.setText("");
                question.setText("Enter your street");
                questionCount++;
            } else if (questionCount==1) {
                street = answer.getText();
                answer.setText("");
                question.setText("Enter your state");
                questionCount++;
            } else if (questionCount==2) {
                state = answer.getText();
                answer.setText("");
                question.setText("Enter your city");
                questionCount++;
            } else if (questionCount==3) {
                city = answer.getText();
                answer.setText("");
                question.setText("Enter your zip code");
                questionCount++;
            } else if (questionCount==4) {
                zip = answer.getText();
                answer.setText("");
                question.setText("Enter product name");
                questionCount++;
                address = new CustomerAddress(title, street, state, city, zip);
                textArea.append(address.GetAddress() + "\n" + "----------------------------------------" + "\n" + "Name               Qty     Price     Total"  + "\n");
            } else if (questionCount==5) {
                pName = answer.getText();
                answer.setText("");
                question.setText("Enter product price (double)");
                questionCount++;
            } else if (questionCount==6) {
                pPrice = Double.parseDouble(answer.getText());
                answer.setText("");
                question.setText("Enter product quantity (int)");
                product = new Product(pName, pPrice);
                questionCount++;
            } else if (questionCount==7) {
                quantity = Integer.parseInt(answer.getText());
                answer.setText("");
                question.setText("Enter name for next product name or click done");
                lineItem = new LineItem(quantity, product);
                textArea.append(lineItem.getLineItem());
                amountDue+=(lineItem.Quantity*pPrice);
                questionCount = 5;
            }
        });
        done.addActionListener((ActionEvent ae) -> {
            if (questionCount==5){
                title = answer.getText();
                answer.setText("");
                question.setText("Invoice complete");
                questionCount = 9;
                textArea.append("----------------------------------------" + "\n" + "Amount Due: $" + amountDue);
            }
        });

        mainPnl.add(question);
        mainPnl.add(answer);
        mainPnl.add(add);
        mainPnl.add(done);
        mainPnl.add(textArea);

        add(mainPnl);

        setTitle("Invoice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }

    public static void main(String[] args){
        JFrame frame = new InvoiceDataCollector();
    }
}
