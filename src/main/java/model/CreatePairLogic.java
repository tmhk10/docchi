package model;

import dao.PairDAO;

public class CreatePairLogic {
	public void execute(Pair fileNames) {
		PairDAO dao = new PairDAO();
		dao.create(fileNames);
	}

}
