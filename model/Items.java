package model;

public class Items implements Calculations{
private String title;
private int quantity;
private double  price;

public Items(String title,int quantity,double price) {
	super();
	this.title=title;
	this.quantity=quantity;
	this.price=price;
	
}
public String getTitle()
{
	return title;
}
public void setTitle(String title)
{
	this.title=title;
}
public int getQuantity()
{
	return quantity;
	
}
public void setQuantity(int quantity)
{
	this.quantity=quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price)
{
	this.price=price;
}
public double calculateTotalAmount(int quantity,double price)
{
	return quantity*price;
}
@Override
public String toString()
{
	return  "Item [title=" + title + ", quantity=" + quantity + ", price=" + price + "]";
}
}
