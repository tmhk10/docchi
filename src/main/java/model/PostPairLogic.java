package model;

import dao.PairDAO;

public class PostPairLogic {
	public void execute(Pair pair) {
		PairDAO dao = new PairDAO();
		dao.create(pair);
	}

}
