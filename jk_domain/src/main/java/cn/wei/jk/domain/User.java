package cn.wei.jk.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 *多个用户对应一个部门
 *在多的一方建立对象  一的一方建立集合
 */
public class User extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	private String  id; 
	/**用户与部门  多对一*/
	private Dept dept;
	/**用户与角色多对多*/
	private Set<Role> roles = new HashSet<Role>(0);
	/**用户与用户的扩展信息    一对一**/
	private UserInfo userInfo;
	/**用户名 */
	private String  userName;
	/**  密码  要加密 */
	private String  password;
	/**状态*/
	private Integer  state;
	
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
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
