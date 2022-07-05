package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/EmpListServ", "/empList"})
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		//parameter : request
		//form의 name값
		String id = request.getParameter("departmentId");
		request.setAttribute("list", dao.selectAll(id));
		request.getRequestDispatcher("/WEB-INF/jsp/empList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
