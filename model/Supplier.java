package model;

import java.io.Serializable;

public class Supplier implements Serializable {
String Sname;
String email;
String phone;

public Supplier(String Sname,String email,String phone)
{
	this.Sname=Sname;
	this.email=email;
	this.phone=phone;
}
public String getName()
{
	return Sname;
}
public void setNAme(String Sname)
{
	this.Sname=Sname;
}
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email=email;
}
public String getPhone()
{
	return phone;
}
public void setPhone(String phone) {
	this.phone=phone;
}
}
