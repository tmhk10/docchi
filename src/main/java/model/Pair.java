package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair implements Serializable{
	@JsonProperty("id")
	private int id;
	@JsonProperty("fileName1")
	private String fileName1;
	@JsonProperty("fileName2")
	private String fileName2;
	@JsonProperty("vote1")
	private int vote1;
	@JsonProperty("vote2")
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
	public void setId(int id) {this.id = id;}
	public String getFileName1() {return fileName1;}
	public void setFileName1(String fileName1) {this.fileName1 = fileName1;}
	public String getFileName2() {return fileName2;}
	public void setFileName2(String fileName2) {this.fileName2 = fileName2;}
	
	public int getVote1() {return vote1;}
	public void setVote1(int vote1) {this.vote1 = vote1;}	
	public int getVote2() {return vote2;}
	public void setVote2(int vote2) {this.vote2 = vote2;}

}
