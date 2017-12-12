package cn.wei.jk.action.sysadmin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.wei.jk.action.BaseAction;
import cn.wei.jk.domain.Dept;
import cn.wei.jk.service.DeptService;
import cn.wei.jk.utils.Page;

/**
 * 部门管理的Action
 * @author Administrator
 *
 */
public class DeptAction extends BaseAction implements ModelDriven<Dept>{
	private static final long serialVersionUID = 1L;

	private Dept model= new Dept();
	@Override
	public Dept getModel() {
		
		return model;
	}
	//分页查询
	private Page page = new Page();
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	/**
	 * 
	 * @return
	 */
	public String list(){
		System.out.println("------------5656566**-----");
		deptService.findPage("from Dept", page, Dept.class, null);
		//设置分页地址
		page.setUrl("deptAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		return "list";
	}
	
	/**
	 * 查看
	 */
	public String toview(){
		//1.调用业务方法，得到ID，得到对象
		Dept dept = deptService.get(Dept.class, model.getId());
		//放入栈顶
		super.push(dept);
		//调转页面
		return "toview";
	}
	/**
	 * 新增部门
	 */
	public String tocreate(){
		//调用业务方法
		List<Dept> deptList = deptService.find("from Dept where state = 1", Dept.class, null);
		
		//将查询的结果放入值栈中
		super.put("deptList", deptList);
		//调转页面
		return "tocreate";
	}
	/**
	 * 保存部门的方法
	 */
	public String insert(){
		//调用业务方法,实现保存
		deptService.saveOrUpdate(model);
		//调转
		return "alist";
	}
	/**
	 * 进入修改页面
	 */
	public String toupdate(){
		//1.根据部门ID,得到一个对象
		Dept obj = deptService.get(Dept.class, model.getId());
		
		//2.将查询到的当前部门对象放到栈顶
		super.push(obj);
		//3.查询父部门
		List deptList = deptService.find("from Dept where state=1", Dept.class, null);
		
		//将当前放在值栈中药修改的对象,从部门表中清楚,目的是为了下拉列表中没有当前放在值栈中的这个对象
		deptList.remove(obj);
		//4.将查询到的父部门结果放入到值栈中,它是放在context局域中\
		super.put("deptList", deptList);
		//调转页面
		return "toupdate";
	}
	
	/**
	 * 更新方法
	 */
	public String update(){
		//调用业务方法  先根据ID查询数据库中的数据
		Dept obj = deptService.get(Dept.class, model.getId());
		obj.setParent(model.getParent());
		obj.setDeptName(model.getDeptName());
		deptService.saveOrUpdate(obj);
		
		return "alist";
	}
	/**
	 * 删除的方法
	 * <input type="checkbox" name="id" value="100" />
	 * <input type="checkbox" name="id" value="3d10032-sf481d5-dfaaa01" />
	 * 	....
	 * model
	 * 		id:String类型
	 * 		具有同名框的一组值如何封装数据?
	 * 		如果服务端是String:
	 * 				1000,d10032-sf481,ss22d5-dfaaa01
	 * 		id:Integer,Float,Double,date类型
	 * 		id=300
	 * 		Integer []id; {100,200,3000}
	 */
	public String delete(){
		
		String ids[] = model.getId().split(", ");
		//调用业务方法,实现批量删除方法
		deptService.delete(Dept.class, ids);
		
		return "alist";
	}

}
