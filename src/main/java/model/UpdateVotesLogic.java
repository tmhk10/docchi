package model;

import dao.VotesDAO;

public class UpdateVotesLogic {
	public void execute(Votes votes) {
		VotesDAO dao = new VotesDAO();
		dao.update(votes);
	}

}
