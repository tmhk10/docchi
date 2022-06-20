package model;

import dao.PairDAO;

public class RemoveLogic {
	public void execute(int id) {
		PairDAO dao = new PairDAO();
		dao.remove(id);
	}

}
