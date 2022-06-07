package model;

import java.io.Serializable;

public class FileNames implements Serializable{
	private int id;
	private String fileName1;
	
	private String fileName2;
	
	public FileNames() {}
	public FileNames(String fileName1, String fileName2) {
		this.fileName1 = fileName1;
		
		this.fileName2 = fileName2;
	}
	public FileNames(int id, String fileName1, String fileName2) {
		this.id = id;
		this.fileName1 = fileName1;
		
		this.fileName2 = fileName2;
	}
	
	public int getId() {return id;}
	public String getFileName1() {return fileName1;}
	
	public String getFileName2() {return fileName2;}

}
