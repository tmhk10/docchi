package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetVotesLogic;
import model.Pair;
import model.UpdateVotesLogic;
import model.VotesLogic;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteSaveServlet")
public class VoteSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメタ取得
		int id = Integer.parseInt(request.getParameter("id"));
		String fileName = request.getParameter("fileName");
		String which = request.getParameter("which");
		
		Pair tempo = new Pair(id, fileName);
		//まず取り出しのLogic
		GetVotesLogic getVotesLogic = new GetVotesLogic();
		Pair pair = getVotesLogic.execute(tempo);
		//+1のLogic
		VotesLogic votesLogic = new VotesLogic();
		if (which != null && which.equals("former")) {
			votesLogic.vote1(pair);
		} else if (which != null && which.equals("latter")){
			votesLogic.vote2(pair);
		}
		
		//保存のLogic
		UpdateVotesLogic updateVotesLogic = new UpdateVotesLogic();
		updateVotesLogic.execute(pair);
		
/*		//再度取り出しのLogic
		GetVotesLogic getVotesLogic = new GetVotesLogic();
		Votes vo = getVotesLogic.execute();
		
		//リクエストスコープにセットしてmain.jspにフォワード
		request.setAttribute("votes", votes);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		d.forward(request, response);
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}