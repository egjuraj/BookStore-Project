package controller;
import model.PurchasedBooks;
import model.TheDate;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PurchasesController {
	
private static final String purchasedf="purchase.bin";
private  File purchasedfile;
ArrayList<PurchasedBooks>purchasedTable;

public PurchasesController() {
	purchasedTable=new ArrayList<>();
	purchasedfile=new File(purchasedf);
	if(purchasedfile.exists()) {
		readPurchasedBooks();
	}
	else {
		writePurchasedBooks();
	}
}

public ArrayList<PurchasedBooks> getPurchasedTabel(){
	return purchasedTable;
}
public void readPurchasedBooks() {
	try {
		FileInputStream fis=new FileInputStream(purchasedf);
		ObjectInputStream ois=new ObjectInputStream(fis);
		purchasedTable=(ArrayList<PurchasedBooks>)
				ois.readObject();
		        ois.close();
		        fis.close();
		       }
	catch(Exception e)
	{
		System.err.println("Be careful!");
	}
}
public void writePurchasedBooks() {
	try {
		FileOutputStream fos=new FileOutputStream(purchasedf);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(purchasedTable);
		oos.close();
		fos.close();
	}
	
	catch(Exception e) {
		System.err.println("Be carfeul!!");
	}
}

public void addBook(int pos, String ISBN, int quantity) {	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	TheDate purchasedDate = new TheDate(sdf.format(new Date()));
	purchasedTable.add(new PurchasedBooks(ISBN, quantity, purchasedDate));
	ProductController pc = new ProductController();
	pc.addQuantity(pos,quantity);
	writePurchasedBooks();
}

}
