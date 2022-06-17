package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetPersonalListLogic;
import model.Login;
import model.Pair;

/**
 * Servlet implementation class ImageCheckServlet
 */
@WebServlet("/ImageCheckServlet")
public class ImageCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//ログインしてる確認取れた時のみ、投稿画面へフォワード
		HttpSession session = request.getSession();
		Login login = (Login)session.getAttribute("login");
		if(login == null) {
			response.sendRedirect("/docchi/MainServlet");
		} else {
			//セッションのnameと等しいcontributorのpairのListを作って、imageCheck.jspにフォワード。
			//データベースからpairsのリストを取得、それをリクエストスコープに保存
			GetPersonalListLogic getPersonalListLogic = new GetPersonalListLogic();
			List<Pair> personalList = getPersonalListLogic.execute(login);
			request.setAttribute("personalList", personalList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/imageCheck.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
