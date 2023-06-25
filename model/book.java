package model;

import java.io.Serializable;

public class book  implements Serializable  {
private String ISBN;
private String title;
private String category;
private String supplier;
private int stock;
private String Author;

public book(String ISBN,String category,int stock,String Author)
{
	this.ISBN=ISBN;
	this.category=category;
	this.stock=stock;
	this.Author=Author;
}
public book(String ISBN,String title,String category,String supplier)
{   stock=0;
	this.ISBN=ISBN;
	this.title=title;
	this.category=category;
	this.supplier=supplier;
}
public String  getISBN()
{
	return ISBN;
}
public void setISBN(String ISBN) {
	this.ISBN=ISBN;
}
public String getTitle()
{
	return title;
	
}
public void setTitle(String Title)
{
	this.title=title;
}

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock=stock;
}
public String getSupplier() {
	return supplier;
}
public void setSupplier(String supplier) {
	this.supplier=supplier;
}
@Override
public String toString() {
	return  "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", supplier=" + supplier
			+ ", stock=" + stock + "]";
}

}