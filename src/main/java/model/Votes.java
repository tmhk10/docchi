package model;

import java.io.Serializable;

public class Votes implements Serializable{
	private int id;
	private int vote1;
	private int vote2;
	
	public Votes() {
		vote1 = 0;
		vote2 = 0;
	}
	
	
	public Votes(int id, int vote1, int vote2) {
		this.id = id;
		this.vote1 = vote1;
		this.vote2 = vote2;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getVote1() {return vote1;}
	public void setVote1(int vote1) {this.vote1 = vote1;}
	
	public int getVote2() {return vote2;}
	public void setVote2(int vote2) {this.vote2 = vote2;}

}
