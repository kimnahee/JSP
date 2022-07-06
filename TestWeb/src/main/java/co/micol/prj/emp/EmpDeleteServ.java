package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empDelete")
public class EmpDeleteServ extends HttpServlet {
	// 삭제처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 파라미터
		String employeeId = request.getParameter("employeeId");
		// 사번 단건조회
		// dao=>delete 메소드
		EmpDAO dao = new EmpDAO();
		int cnt = dao.delete(employeeId);
		
		response.getWriter()
				.append("<script>")
				.append("alert('" + cnt + "건 삭제완료')")
				.append("location.href='empList';")
				.append("</script>");
		
		//response.getWriter().append(cnt+"건 삭제");
		//request.setAttribute("msg", cnt + "건 삭제");
		//request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
