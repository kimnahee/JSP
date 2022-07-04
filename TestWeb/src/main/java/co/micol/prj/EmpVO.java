package co.micol.prj;

public class EmpVO {
	//필드
	private String employeeId;
	private String firstName;
	private String salary;
	
	//생성자
	public EmpVO() {
		super();
	}
	
	public EmpVO(String employeeId, String firstName, String salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}

	//Getter/Setter
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
