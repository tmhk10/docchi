package model;

import java.io.Serializable;

public class Pair implements Serializable{
	private int id;
	private String fileName1;	
	private String fileName2;
	private int vote1;
	private int vote2;
	
	public Pair() {}
	public Pair(String fileName1, String fileName2) {
		this.fileName1 = fileName1;	
		this.fileName2 = fileName2;
	}
	public Pair(int id, String fileName1) {
		this.id = id;
		this.fileName1 = fileName1;		
	}
	public Pair(int id, String fileName1, String fileName2, int vote1, int vote2) {
		this.id = id;
		this.fileName1 = fileName1;
		this.fileName2 = fileName2;
		this.vote1 = vote1;
		this.vote2 = vote2;
	}
	
	public int getId() {return id;}
	public String getFileName1() {return fileName1;}	
	public String getFileName2() {return fileName2;}
	
	public int getVote1() {return vote1;}
	public void setVote1(int vote1) {this.vote1 = vote1;}	
	public int getVote2() {return vote2;}
	public void setVote2(int vote2) {this.vote2 = vote2;}

}
