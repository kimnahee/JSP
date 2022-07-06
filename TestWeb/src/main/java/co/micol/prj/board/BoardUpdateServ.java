package co.micol.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardUpdate")
public class BoardUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdateServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 단건 조회
		BoardDAO dao = new BoardDAO();

		String boardId = request.getParameter("id");
		request.setAttribute("board", dao.selectOne(boardId));
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// DB 수정처리
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);

		BoardDAO dao = new BoardDAO();
		int cnt = dao.update(vo);

	}

}
