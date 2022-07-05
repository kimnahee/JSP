package co.knh.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptUpdate")
public class DeptUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptUpdateServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정페이지 요청
		String departmentId = request.getParameter("deparmentId");
		//부서번호로 단건 조회
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("dept", deptDAO.selectOne(departmentId));
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//DB 등록처리(form 에서 받아오는 데이터)
		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		
		//vo 에 파라미터 담기
		DeptVO vo = new DeptVO();
		vo.setDeptId(id);
		vo.setDeptName(name);
		
		DeptDAO deptDAO = new DeptDAO();
		int cnt = deptDAO.deptInsert(vo);
		response.getWriter()
				.append(cnt+"건 입력");
	}

}
