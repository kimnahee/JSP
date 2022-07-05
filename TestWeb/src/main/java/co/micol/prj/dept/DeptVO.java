package co.micol.prj.dept;

public class DeptVO {
	//필드
	private String deptId;
	private String deptName;
	private String managerId;
	private String locId;
	
	//생성자
	public DeptVO() {
		super();
	}
	public DeptVO(String deptId, String deptName, String managerId, String locId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.managerId = managerId;
		this.locId = locId;
	}
	
	//getter, setter
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	
	
}
