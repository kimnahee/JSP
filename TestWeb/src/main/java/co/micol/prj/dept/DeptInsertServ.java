package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록페이지 요청
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//DB 등록처리
		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		
		//vo에 파라미터 담기
		DeptVO vo = new DeptVO();
		vo.setDeptId(id);
		vo.setDeptName(name);
		
		//DB 처리
		DeptDAO deptDAO = new DeptDAO();
		int cnt = deptDAO.deptInsert(vo);
		
		//결과출력
		response.getWriter()
				.append(cnt+"건이 등록됨");
	}

}
