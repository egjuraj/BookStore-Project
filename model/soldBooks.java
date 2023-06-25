package model;
import java.io.Serializable;

public class soldBooks implements Serializable{
private String ISBN;
private String title;
private int quantity;
private double price;
private TheDate date;

public soldBooks(String ISBN,String title,int quantity,double price,TheDate date)
{
   	this.ISBN=ISBN;
	this.title=title;
	this.quantity=quantity;
	this.price=price;
	this.date=date;
	
}
public String getTitle()
{
	return title;
}
public void setTitle(String title)
{
	this.title=title;
}
public double getQuantity()
{
	return quantity;
}
public void setQuantity(int quantity)
{
	this.quantity=quantity;
}
public double getPrice()
{
	return price;
}
public void setPrice(double price)
{
	this.price=price;
}
public TheDate getDate()
{
	return date;
}
public void setdate(TheDate date)
{
	this.date=date;
}
public String getISBN()
{
	return ISBN;
}
public void setISBN()
{
	this.ISBN=ISBN;
}
@Override
public String toString()
{
	return "SellBooks [ISBN="+ISBN+",title="+title+",quantity="+quantity+",sellprice="+price+",sellDate="+date+"]";
}

}
