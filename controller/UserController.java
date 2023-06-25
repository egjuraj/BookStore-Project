package controller;
import model.Librarian;
import model.Manager;
import model.User;
import javafx.scene.control.TableView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class UserController {
	public static final String filename="user.bin";
private ArrayList<User>users;
private File file;

public UserController()
{
	users=new ArrayList<>();
	file=new File("filename");
	if(file.exists()) {
		readUser();
	}
	else {
		writeUsers();
	}
}
private void readUser() {
	try {
		FileInputStream fis=new FileInputStream(filename);
		ObjectInputStream ois=new ObjectInputStream(fis);
	users=(ArrayList<User>)ois.readObject();
	fis.close();
	ois.close();
	
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}	
}
private void writeUsers() {
	try {
		FileOutputStream fos=new FileOutputStream(filename);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.close();
		fos.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
}
public void delete(User u)
{
	this.users.remove(positionsOfUser(u));
	writeUsers();
}
private void addUser(User u) {
	this.users.add(u);
	writeUsers();
}
public boolean signUp(String firstName,String lastName,String userName,String password,String verifyPassword,String phone,String proffesion,String salary) {
if(password.equals(verifyPassword)) {
	 User u=new User(firstName,lastName,proffesion,phone,userName,password,salary);
	 this.addUser(u);
	 writeUsers();
	 return true;
			 }
return false;
	 }
public User login(String username,String password) {
	System.out.println("Users:"+this.users);
	for(User user:users) {
		if(user.getUserName().equals(username)&&user.getPassword().equals(password)) {
			return user;
		}
	}
	return null;
}
public ArrayList<User>getUsers(){
	return this.users;
}
public void editUser(User updateUser,int index) {
	this.users.set(index,updateUser);
	writeUsers();
}
public int positionsOfUser(User currentUser) {
	for(int i=0;i<this.users.size();i++) {
		if(currentUser.getUserName().equals(this.users.get(i).getUserName())) {
			return i;
		}
	}
	return -1;
}
}


