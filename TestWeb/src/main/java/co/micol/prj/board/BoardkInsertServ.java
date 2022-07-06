package co.micol.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardInsert")
public class BoardkInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardkInsertServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//등록 페이지 요청
		request.getRequestDispatcher("WEB-INF/jsp/board/boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//DB 등록처리
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String rdt = request.getParameter("rdt");
		String hit = request.getParameter("hit");
		
		//vo에 파라미터 담기
		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setRdt(rdt);
		vo.setHit(hit);
		
		//DB 처리
		BoardDAO dao = new BoardDAO();
		int cnt = dao.insert(vo);
		//결과출력
		response.getWriter().append(cnt+"건 등록");
	}

}
