package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Category;
public class CategoryController {
private ArrayList<Category>category;
private File file;
public CategoryController(){
	category=new ArrayList<>();
	file=new File("category.bin");
	if(file.exists()) {
		readCategory();
	}
	else
	{
		writeCategory();
	}
}
public void writeCategory() {
	
try {
	FileOutputStream fos=new FileOutputStream(file);
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	oos.writeObject(category);
	oos.close();fos.close();
}  catch (FileNotFoundException e) {
	System.err.println("File cannot be written!!!");

}
catch (IOException e) {
	System.err.println("Problem with writing object");
}
}

	private void readCategory() {
		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			category=(ArrayList<Category>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		}
	}

	public ArrayList<Category> getCategories() {
		return category;
	}

	public void addCategory(Category c) {
		category.add(c);
		writeCategory();
	}

}

