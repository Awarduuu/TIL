package day05;

import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>, Comparator<Student>{
	private int sno;
	private String name;
	private int age;
	private String addr;
	
	public Student() {}
	public Student(int sno, String name, int age, String addr) {
		super();
		this.sno = sno;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [sno=");
		builder.append(sno);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int compareTo(Student st) {
		// TODO Auto-generated method stub
		return st.getSno() - sno; // 
	}
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge();
	}
	
	
}
