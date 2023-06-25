package model;
import java.time.*;
import java.util.ArrayList;

public class Bill {
private String billName;
private String title;
private LocalDate billDate;
private static int billNr=0;
String supplier;
private double price;
int quantitySold;
public Bill(String LibrarianName, String supplier, LocalDate billDate, double total, int quantity) {
	this.billName = LibrarianName;
	this.billDate = billDate;
	this.price = total;
	this.supplier = supplier;
	quantitySold = quantity;
	++billNr;
}

public static int getBillNo() {
	return billNr;
}

public String getBillName() {
	return billName;
}

public LocalDate getBillDate() {
	return billDate;
}

public double getPrice() {
	return price;
}

@Override
public String toString() {
	return "Bill \n"+"Bill Name=" + billName + "\n supplier=" + supplier + "\n billDate=" + billDate + "\n price="
			+ price + "\n quantitySold=" + quantitySold+"\n\n";
}
}
