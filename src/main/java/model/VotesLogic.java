package model;

public class VotesLogic {
	
	public void vote1(Votes votes) {
		int count = votes.getVote1();
		votes.setVote1(count + 1);
	}	
	public void vote2(Votes votes) {
		int count = votes.getVote2();
		votes.setVote2(count + 1);
	}

}
