package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Supplier;

public class SupplierController {
	private File file;
	private ArrayList<Supplier>suppliers;
	
	public SupplierController() {
		suppliers=new ArrayList<>();
		file=new File("supplier.bin");
		if(file.exists()) {
			readSuppliers();
			
		}
		else {
			writeSuppliers();
		}
	}
	
	private void writeSuppliers() {
		try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(suppliers);
			oos.close();
			fos.close();
		}
		catch(Exception e) {
			System.err.println("Be Careful");
		}
	}
	private void readSuppliers() {
		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			suppliers=(ArrayList<Supplier>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e) {
			System.err.println("File not found!!!");
		}
	}
	public ArrayList<Supplier>getSuppliers(){
		return suppliers;
	}
	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
		writeSuppliers();
	}
	public boolean RegisterSupplier(String s) {
		for(Supplier s1:suppliers) {
			if(s1.getName().equals(s))
				return true;
		}
		return false;
	}
	public void deleteSupplier(int position) {
		suppliers.remove(position); 
		writeSuppliers();

	}
	public int getPosition(Supplier supplier) {

		for(int i=0; i<suppliers.size(); i++)
		{
			if(suppliers.get(i).getName().equals(supplier.getName()))
				return i;
		}	
		return -1;
	}
}
