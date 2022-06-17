package model;

import java.util.List;

import dao.PairDAO;

public class GetPersonalListLogic {
	public List<Pair> execute(Login login) {
		PairDAO dao = new PairDAO();
		List<Pair> personalList = dao.findSome(login);
		return personalList;
	}


}
