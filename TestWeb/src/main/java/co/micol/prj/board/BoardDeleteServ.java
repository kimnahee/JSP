package co.micol.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardDelete")
public class BoardDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDeleteServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List 에서 id를 받아오기
		String delId = request.getParameter("id");
		//게시글 단건 조회
		//dao > delete 메소드
		BoardDAO dao = new BoardDAO();
		int cnt = dao.delete(delId);
		
		/*
		 * response.getWriter() .append(cnt + "건 삭제완료");
		 */
		
		response.sendRedirect("boardList");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
