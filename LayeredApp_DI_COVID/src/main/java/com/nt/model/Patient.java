package com.nt.model;

public class Patient {
	private Integer pno;
	private String pname;
	private String paddrs;
	private String sex;
	private Byte age;
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddrs() {
		return paddrs;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Byte getAge() {
		return age;
	}
	public void setAge(Byte age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patient [pno=" + pno + ", pname=" + pname + ", paddrs=" + paddrs + ", sex=" + sex + ", age=" + age
				+ "]";
	}
	
	
	
}
