package model;

public class Account {
	private int id;
	private String name;
	private String pass;
	private String sex;
	private String dob;
	
	public Account() {}
	public Account(String name, String pass, String sex, String dob) {
		
		this.name = name;
	    this.pass = pass;
	    this.sex = sex;
	    this.dob = dob;
	}
	public Account(int id, String name, String pass, String sex, String dob) {
		this.id = id;
		this.name = name;
	    this.pass = pass;
	    this.sex = sex;
	    this.dob = dob;
	}
	public int getId() {return id;}

	public String getName() {return name;}

	public String getPass() {return pass;}	    
	
	public String getSex() {return sex;}
	
	public String getDob() {return dob;}

}