package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Login;
import model.Pair;
import model.PostPairLogic;

/**
 * Servlet implementation class ImagePostServlet
 */
@WebServlet("/ImagePostServlet")
@MultipartConfig(
	location="",
	maxFileSize=1024*1024*2
)
public class ImagePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagePostServlet() {
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
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/imagePost.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		//ファイルをPartオブジェクトとして取得。リクエストパラメラ使って。
		Part part1 = request.getPart("firstOne");
		Part part2 = request.getPart("secondOne");
		
			//ファイル名を取得、次に格納先を指定
			String filename1 = part1.getSubmittedFileName();
			String filename2 = part2.getSubmittedFileName();
			String path = getServletContext().getRealPath("/upload");
			//uploadフォルダに格納
			part1.write(path + File.separator + filename1);
			part2.write(path + File.separator + filename2);
			
			//画像ファイル名をデータベースに追加
			Pair pair = new Pair(filename1, filename2);
			PostPairLogic postPairLogic = new PostPairLogic();
			postPairLogic.execute(pair);
		
		
/*		//データベースからファイル名ペアのリストを取得、それをリクエストスコープに保存
		GetPairListLogic getPairListLogic = new GetPairListLogic();
		List<Pair> pairList = getPairListLogic.execute();
		request.setAttribute("pairList", pairList);
*/		
		//imagePostOK.jspへフォワード
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/imagePostOK.jsp");
		d.forward(request, response);
		
	}

}
