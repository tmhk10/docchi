package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
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
		
		Login login = new Login(name, pass);
		LoginLogic loginLogic = new LoginLogic();
		boolean result = loginLogic.execute(login);
		
		if (result) {
			//セッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			//loginOK.jspへフォワード
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			d.forward(request, response);
		} else {
			//loginNG.jspへフォワード
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/loginNG.jsp");
			d.forward(request, response);
		}
	}

}
