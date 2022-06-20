package model;

import java.util.List;

import dao.AccountDAO;

public class GetUserNameListLogic {
	public List<String> execute(){
		AccountDAO dao = new AccountDAO();
		List<String> nameList = dao.findByName();
		return nameList;
	}

}
