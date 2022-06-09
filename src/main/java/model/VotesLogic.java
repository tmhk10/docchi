package model;

public class VotesLogic {
	
	public void vote1(Pair pair) {
		int count = pair.getVote1();
		pair.setVote1(count + 1);
		
	}	
	public void vote2(Pair pair) {
		int count = pair.getVote2();
		pair.setVote2(count + 1);
		
	}

}
