package model;

import java.util.List;

import dao.PairDAO;

public class GetPairListLogic {
	public List<FileNames> execute() {
		PairDAO dao = new PairDAO();
		List<FileNames> pairList = dao.findAll();
		return pairList;
	}

}
