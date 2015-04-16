package rPOS;

public class User {

	
	// whats is user status manager?
	
	public static int userStatus = 2;
// private fields so only we can cahnge user information
	private boolean duser;
	private boolean mang = false;  	// is this user a manager Y/N. default is not
	private int uid;
	private int status;
	private String pword;
	private String fname;
	private String lname;
	private String addy;
	private int phonenum;
	private String gender;
	private float payrate;

	public User(int userID, int userStatus, String password) 
	{
		// TODO Auto-generated constructor stub
//constructor given initial values.
		uid = userID;
		status = userStatus;
		pword = password;
		
		
	}
	// need to check that the deletion is done by management not just another user. 
	// pass the function the managers ID and it will check the bool value for us.
	
	public void rmvEmp(int uid, int mangid)
	{
		if(mangid.getMang == true)
		{
		this.uid =0;
		this.pword = "";
		this.fname = "":
		this.lname = "";
		this.addy = "";
		this.phonenum = "";
		this.gender ="";
		}
		
	}
	
	/**    **/
	/** mutators to allow manipulation of private fields**/
	/** add a First name    **/
	
	public void addFname(String first)
	{
		this.fname = first;
		
	}
	/**   add a last name **/
	
	public void addLname(String last)
	{
		this.lname = last;
		
	}
	
	/**   add an address **/
	public void addAddress(String live)
	{
		this.addy = live;
		
	}
	
	/**   add a phone number **/
	public void addPhone(int contact)
	{
		this.phonenum = contact;
		
	}
	/**   add gender **/
	public void addGender(String sex)
	{
		this.gender = sex;
		
	}
	
	/**   sets the payrate to whatever the input is **/
	public void addPay(float dollars)
	{
		this.payrate = dollars; 
		
	}
	
	/**   increases the current payrate by the amount given **/
	
	public void raiseRate(float inc)
	{
		this.payrate= this.payrate + inc;		
		
	}
	
	/**   Remove managerial privileges **/
	//remove management status
	public void demote(int uid)
	{
		this.mang = false;
	
	}
	

/** gives a user management priviliges.*/
	public void promote(int uid)
	{
		if(mangid.getMang == true)
		{
			this.mang = true;
		}
		
	/*accessors so the managres can get the employee information **/
		
		/** retrieves the users Password   **/
	
	public String getPword()
	{
		return this.pword;
	}
	/**   retireves the users first name **/
	public String getFname()
	{
		return this.fname;
		
	}
	
	/**   retrieves the users last name **/
	public String getLname()
	{
		return this.lname;
		
	}
	
	/**   retrieves the users address **/
	public String getAddress()
	{
		return this.addy;
		
	}
	
	/**   retrieves the users phone number **/
	
	public int getPhone()
	{
		return this.phonenum;
		
	}
	/**   retrieves the gender **/
	public String getGender()
	{
		return this.gender;
		
	}
	/**   is the user a manager? Bool value **/
	public boolean getMang();
	{
		return this.mang;
	}
	/**   retrieves the users payrate **/
	public float getPayrate();
	{
		return this.payrate
		
	}
	
	
	
}
