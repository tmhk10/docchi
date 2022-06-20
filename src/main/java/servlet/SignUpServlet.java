package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.SignUpLogic;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//signUp.jspにフォワード
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//リクエストパラメラ取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String dob = year + "-" + month + "-" + day;
		
		//登録
		Account account = new Account(name,pass,sex,dob);
		SignUpLogic signUpLogic = new SignUpLogic();
		boolean result = signUpLogic.execute(account);
		
		if(result) {
			//セッションスコープに保存
			Login login = new Login(name,pass);
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			//signUpOK.jspへフォワード
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/signUpOK.jsp");
			d.forward(request, response);
		} else {
			//signUpNG.jspへフォワード
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/signUpNG.jsp");
			d.forward(request, response);
		}
	}	

}
