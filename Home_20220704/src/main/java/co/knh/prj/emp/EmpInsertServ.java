package co.knh.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.knh.prj.dept.DeptDAO;

@WebServlet("/EmpInsertServ")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpInsertServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 등록 페이지 요청
		//jobs, 부서, 사원리스트
		EmpDAO empDAO = new EmpDAO();
		DeptDAO deptDAO = new DeptDAO();
		String employeeId = request.getParameter("employeeId");
		request.setAttribute("jobs", empDAO.selectJobs());
		request.setAttribute("depts", deptDAO.selectDept());
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//DB 등록처리 => form(request) 에서 파라미터를 가져옴
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		
		//vo 생성 & 가져온 파라미터 담기
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jobId);
		
		//DB 처리
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.insert(vo); //cnt=1
		
		response.getWriter()
				.append(cnt+"건 등록");
	}

}
