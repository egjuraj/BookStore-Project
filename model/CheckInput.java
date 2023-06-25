package model;

public class CheckInput {
public boolean checkPassword(String pass) {
		return pass.matches("[a-zA-Z0-9]{10,}");
	}
public boolean checkUsername(String username){
	return  username.matches("^[A-Za-z]{3,}");
}
public boolean checkEmail(String email)
{
	return email.matches("[a-z]*@.+[.]com");
}
public boolean checkSalary(double salary)
{
	return true;
}
public boolean checkPhone(String phone) {
	return phone.matches("06[789]\\d{7}");
}


}
