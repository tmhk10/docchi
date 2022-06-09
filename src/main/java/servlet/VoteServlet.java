package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FileNames;
import model.GetVotesLogic;
import model.UpdateVotesLogic;
import model.Votes;
import model.VotesLogic;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
		
		FileNames fileNames = new FileNames(id, fileName);
		//まず取り出しのLogic
		GetVotesLogic getVotesLogic = new GetVotesLogic();
		Votes votes = getVotesLogic.execute(fileNames);
		//+1のLogic
		VotesLogic votesLogic = new VotesLogic();
		if (which != null && which.equals("former")) {
			votesLogic.vote1(votes);
		} else if (which != null && which.equals("latter")){
			votesLogic.vote2(votes);
		}
		
		//保存のLogic
		UpdateVotesLogic updateVotesLogic = new UpdateVotesLogic();
		updateVotesLogic.execute(votes);
		//再度取り出しのLogic
		//GetVotesLogic getVotesLogic = new GetVotesLogic();
		//Votes vo = getVotesLogic.execute();
		
		//リクエストスコープにセットしてmain.jspにフォワード
		request.setAttribute("votes", votes);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
