package model;


import dao.VotesDAO;

public class GetVotesLogic {
	public Pair execute(Pair tempo) {
		VotesDAO dao = new VotesDAO();
		Pair pair = dao.findOne(tempo);
		return pair;
	}	
}
