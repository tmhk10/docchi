package model;

import dao.VotesDAO;

public class UpdateVotesLogic {
	public void execute(Pair pair) {
		VotesDAO dao = new VotesDAO();
		dao.update(pair);
	}

}
