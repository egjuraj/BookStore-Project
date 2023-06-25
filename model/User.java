package model;
import java.io.Serializable;
public class User implements Serializable {
	private String firstName;
	private String lastName;
    private String proffesion;
    private String phone;
    private String email;
    private String salary;
    private String password;
    private String username;
    private String birthday;
    private  int ID;
    private  static int nofUser=0;
    public static final int NOTDEF = -1;
    public static final int CASHIER = 0;
    public static final int MANAGER = 1;
    public static final int ADMIN = 2;
    private int positon = NOTDEF;
    
   public User(String firstName,String lastName,String proffesion,String phone,String username,String password,String salary) {
	   this.firstName=firstName;
	   this.lastName=lastName;
	   this.proffesion=proffesion;
	   this.salary=salary;
	   this.password=password;
	   this.username=username;
	   this.phone=phone;
	   this.ID=nofUser++;
	
   }
    
   public String getFirstName()
   {
	   return firstName;
	   
   }
   public void setFirstName(String firstName)
   {
	   this.firstName=firstName;
   }
   public String getlastName()
   {
	   return lastName;
   }
   public void setLastName(String lastName)
   {
	   this.lastName=lastName;
   }
public String getSalary()
{
	return salary;
}
public void setSalary(String salary)
{
	this.salary=salary;
}
public String getPhonenr()
{
	return phone;
}
public void setPhonenr(String phone)
{
	this.phone=phone;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password)
{
	this.password=password;
}
public String getUserName()
{
	return username;
}
public void setUserName(String username)
{
	this.username=username;
}
public String getBirthday()
{
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday=birthday;
}
public static int getNrOfUsers() {
	return nofUser;
}

public static void setNrOfUsers(int nofUser) {
	User.nofUser = nofUser;
}
public int getId() {
	return ID;
}
public int getPosition() {
	return positon;
}
public void setPosition(int positon) {
	this.positon=positon;
}
@Override
public String toString() {
	return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", phone=" + phone
			+ ", username=" + username + ", profession=" + proffesion + ", salary=" + salary + ", birthday="
			+ birthday + ", id=" + ID + "position="+positon+"]";
}

}

