package model;
import java.io.Serializable;
public class PurchasedBooks implements Serializable {
	private int quantity;
	private String ISBN;
	private String title;
	private TheDate boughtDate;

	public PurchasedBooks(String ISBN,int quantity,TheDate boughtDate)
	{
		this.ISBN=ISBN;
		this.quantity=quantity;
		this.boughtDate=boughtDate;
		
	}
public String getISBN()
{
	return ISBN;
}
public int getQuantity()
{
	return quantity;
}
public TheDate getBoughtDate()
{
	return boughtDate;
}
public String toString()
{
	return "Purchased Book [ISBN="+ISBN+"Title="+title+"Quantity="+quantity+"Bought Date="+boughtDate+"]"
;}
}
