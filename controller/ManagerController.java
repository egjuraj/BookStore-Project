package controller;
import java.io.File;
import java.util.ArrayList;

import model.Items;
import model.Manager;
public class ManagerController {
private ArrayList<Manager>managers;
private ArrayList<Items>item;
private ArrayList<LibrarianController>librarian;
private int nrofItems=0;
File file;

public ManagerController() {//default constructor.that create an array list with manager
	managers=new ArrayList<>();
	
}
public ArrayList<Manager>getsManager(){//method gets to return menagers;
	return managers;
}
public void setManager(ArrayList<Manager>managers) {//method sets to set the manager in arrayList
	this.managers=managers;
}
public int getNrOfItems() {//I Create a get method for nr of items to get nr of items; 
	return nrofItems;
}
public void setNrOfItems(int nrOfItems) {//Icreate a set method to set nr of items
	this.nrofItems=nrOfItems;
}
public void addItems(Items i) {//we create this method to add items and to increment the nr of items
	item.add(i);
	nrofItems++;
}

public String CheckLibrarianPerformance(LibrarianController librarian) {

	if(librarian.getNrBills()>=5)
	  return "OK";
	else return "FAIL";
}

}
