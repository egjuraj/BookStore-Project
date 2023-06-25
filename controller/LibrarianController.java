package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Bill;
import model.Librarian;
import model.book;
public class LibrarianController {
	
private ArrayList<Librarian>librarian;
File file;
private int nrofbill=0;

public LibrarianController() {
	librarian=new ArrayList<>();
	
}
public void createBill(Librarian lib) throws FileNotFoundException, IOException{
	file = new File("data.bin");
	FileOutputStream fos = new FileOutputStream(file); 
	ObjectOutputStream oos = new ObjectOutputStream(fos); 
	oos.writeObject(lib);
	fos.close();
	oos.close();
	nrofbill++;
}
public ArrayList<Librarian> getLibrarian() {
	return librarian;
}
public void setCashier(ArrayList<Librarian> librarian) {
	this.librarian = librarian;
}

public void setNrBills(int nrofbill) {
	this.nrofbill = nrofbill;
}

public int getNrBills() {
	return this.nrofbill;
}
public void outOfStock(int stock,String ISBN) {

		
	}
	
}

