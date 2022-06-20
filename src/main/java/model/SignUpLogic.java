package model;

import dao.AccountDAO;

public class SignUpLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.create(account);
		return result;
	}

}
