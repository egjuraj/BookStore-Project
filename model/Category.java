package model;
import java.io.Serializable;
public class Category implements Serializable{
String zhaner;
public Category(String zhaner)
{
	this.zhaner=zhaner;
	
}
public String toString()
{
	return zhaner;
}

}
