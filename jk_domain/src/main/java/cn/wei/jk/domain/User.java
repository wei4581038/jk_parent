package cn.wei.jk.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author Administrator
 *多个用户对应一个部门
 *在多的一方建立对象  一的一方建立集合
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	private String  id; 
	/**用户与部门  多对一*/
	private Dept dept;
	/**用户名 */
	private String  userName;
	/**  密码  要加密 */
	private String  password;
	/**状态*/
	private Integer  state;
	/**创建者的ID */
	private String  createBy; 
	/**  创建者所在的部门 */
	private String  createDept;
	/**创建时间 */
	private Date  createTime;
	/**更新者的ID */
	private String updateBy;
	/** 更新时间  */
	private Date  updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
