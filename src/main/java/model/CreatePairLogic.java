package model;

import dao.PairDAO;

public class CreatePairLogic {
	public void execute(Pair fileNames,Login login) {
		PairDAO dao = new PairDAO();
		dao.create(fileNames,login);
	}

}
