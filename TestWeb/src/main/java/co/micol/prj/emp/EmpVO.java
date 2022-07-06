package co.micol.prj.emp;

public class EmpVO {
	//필드
	private String employeeId;
	private String lastName;
	private String salary;
	private String email;
	private String hireDate;
	private String jobId;
	private String departmentId;
	
	
	

	//생성자
	public EmpVO() {
		super();
	}
	
	public EmpVO(String employeeId, String lastName, String salary) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.salary = salary;
	}

	public EmpVO(String employeeId, String lastName, String salary, String email, String hireDate, String jobId) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	//Getter/Setter
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
}
