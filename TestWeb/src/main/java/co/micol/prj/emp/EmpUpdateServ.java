package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empUpdate")
public class EmpUpdateServ extends HttpServlet {

	//수정페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DB 조회
		//jobs, 부서, 사원리스트
		EmpDAO dao = new EmpDAO();
		DeptDAO deptDAO = new DeptDAO();
		//setAttribute(넘겨주는 속성명, 넘겨주는 값)
		request.setAttribute("jobs", dao.selectJobs()); 
		request.setAttribute("depts", deptDAO.selectDept()); 
		//deptDAO 의 selectDept() 결과를 "depts"라는 이름으로 넘겨줌(request에 담겨서 같이 넘어감)
		//사번 단건조회
		String employeeId = request.getParameter("employeeId");
 		request.setAttribute("emp", dao.selectOne(employeeId));
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate.jsp").forward(request, response);
	}

	// 수정처리
	// source => override => dopost 추가
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//DB 등록처리 => form(request) 에서 파라미터를 가져와서
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		String salary = request.getParameter("salary");
		
		//vo에 가져온 파라미터 담기
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jobId);
		vo.setSalary(salary);
		
		//DB 처리(insert를 진행하면 cnt 반환 >> 성공하면 1, 실패하면 0
		EmpDAO dao = new EmpDAO();
		int cnt = dao.update(vo); //
		
		response.getWriter()
				.append(cnt+"건 등록");
	}

}
