package sample06;

import org.springframework.beans.factory.annotation.Value;

public class EmpDTO {
	@Value("10")
	private int empno;
	@Value("sangwoo")
	private String name;
	@Value("student")
	private String job;
	
	public EmpDTO() {
		System.out.println("EmpDTO 생성자 호출");
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
