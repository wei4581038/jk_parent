package cn.wei.jk.domain;

import java.util.Date;
/**
 * 
 * @author Administrator
 *多个用户对应一个部门
 *在多的一方建立对象  一的一方建立集合
 */
public class UserInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	/*姓名*/
	private String name;  
	/*用户与直属领导  多对一*/
	private User manager;  
	 /**入职时间*/
	private Date joinDate; 
	/*薪水*/
	private Double salary;  
	/*出生日期*/
	private Date birthday;  
	/*姓别*/
	private String gender;  
	/*岗位*/
	private String station;  
	/*电话*/
	private String telephone;  
	/*等级*/
	private Integer degree;  
	/*备注信息 说明信息*/
	private String remark;  
	/*排序*/
	private Integer orderNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}  
	
	
}
