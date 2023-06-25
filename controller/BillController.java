package controller;
import java.io.*;
import model.Bill;
import java.util.ArrayList;
public class BillController {
private ArrayList<Bill>bills;
File file;
Bill bill;
public BillController() {
    bills = new ArrayList<>();
    file = new File("bills.bin");
    if(file.exists())
    	readBill();

}
	public void readBill() {
	        try {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            bills = (ArrayList<Bill>) 
	            ois.readObject();
	            fis.close();
	            ois.close();
	        } catch(Exception i) {
	            System.out.println(i.getMessage());
	        }

	    }
	  public void addBill(Bill bill) {
	        bills.add(bill);
	        writeBill(bill);
	    }

	
public void writeBill(Bill bill) {
    try {
        File f = new File("bill");
        f.mkdir();
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File(f+ "/Librarian.txt"), true));
        pw.println(bill.toString());
        pw.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error! File cant be found!!!");
    }

}
}
