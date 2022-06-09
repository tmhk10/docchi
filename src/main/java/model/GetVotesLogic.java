package model;

import dao.VotesDAO;

public class GetVotesLogic {
	public Votes execute(FileNames fileNames) {
		VotesDAO dao = new VotesDAO();
		Votes votes = dao.findOne(fileNames);
		return votes;
	}	
}
