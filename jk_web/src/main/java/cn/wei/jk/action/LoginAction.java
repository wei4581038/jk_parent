package cn.wei.jk.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import cn.wei.jk.domain.User;
import cn.wei.jk.utils.SysConstant;
import cn.wei.jk.utils.UtilFuns;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;


	//SSH传统登录方式
	public String login() throws Exception {
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}
//		return "login";
		if(UtilFuns.isEmpty(username)) {
			return "login";
		}
		try {
			/*
			 * 使用shiro的条件
			 */
			//1.得到Subject
			Subject subject = SecurityUtils.getSubject();
			
			//2.调用登录方法
			UsernamePasswordToken toke = new UsernamePasswordToken(username, password);
			subject.login(toke);//当这一行代码执行时.就会自动跳入到AuthRealm中的认证方法
			
			//3.登录成功时,就从Shiro中取出用户的登录信息
			User user =  (User) subject.getPrincipal();
			
			//4.将用户放入到Session中
			session.put(SysConstant.CURRENT_USER_INFO, user);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.put("errorInfo", "对不起,用户名或密码错误");
			return "login";
		}
		
		
		return SUCCESS;
	}
	
	
	//退出
	public String logout(){
		session.remove(SysConstant.CURRENT_USER_INFO);		//删除session
		
		return "logout";
	}
	
	

	
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

