package model;

public class Administrator  extends User{
	private String access_level;
	public Administrator(String firstName,String lastName,String proffesion,String phone,String username,String password,String salary)
	{
		super(firstName,lastName,proffesion,phone,username,password,salary);
		
	}
	public String getaccessLevel()
	{
		return access_level;
	}
	public void setAccessLevel(String access_level)
	{
		this.access_level=access_level;
	}
	@Override
	public String toString() {
		return "Manager [access_level=" + access_level + "]";
	}
	}



