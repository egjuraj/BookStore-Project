package controller;
import java.io.*;
import model.book;
import java.util.ArrayList;
public class ProductController {
private ArrayList<book>books;
private static final String file="books.bin";
private File files;
public ProductController() {
	books=new ArrayList<>();
	files=new File(file);
	if(files.exists()) {
		readBooks();
	}
	else {
		writeBooks();
	}
}
public ArrayList<book>getBooks(){
	return books;
}
private void readBooks() {
	try {
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		books=(ArrayList<book>)
				ois.readObject();
		        ois.close();
		        fis.close();
	}
	catch(Exception e) {
		System.err.println(e.getMessage());
	}
}
public void writeBooks() {
	try {
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(books);
		oos.close();
		fos.close();
	}
	catch(Exception e) {
		System.err.println("Be Careful!");
	}
}
public void addBooks(book b) {
	books.add(b);
	writeBooks();
}

public void addQuantity(int position, int quantity) {
	books.get(position).setStock(books.get(position).getStock()+quantity);
	writeBooks();
}
public void deleteBooks(book b) {
	   books.remove(b);
		writeBooks();
	}
public boolean useISBN(String ISBN) {
	for(book p : books) {
		if((p.getISBN()).equals(ISBN)) {
			return true;
		}
	}			
	return false;
}

public int getPosition(book b) {

	for(int i=0; i<books.size(); i++)	{
		if(books.get(i).getISBN()==b.getISBN())
			return i;	}	
	return -1;
}



}
