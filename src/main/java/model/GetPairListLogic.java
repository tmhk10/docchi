package model;

import java.util.List;

import dao.PairDAO;

public class GetPairListLogic {
	public List<Pair> execute() {
		PairDAO dao = new PairDAO();
		List<Pair> pairList = dao.findAll();
		return pairList;
	}

}
