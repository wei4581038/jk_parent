package cn.wei.jk.service.Impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.wei.jk.dao.BaseDao;
import cn.wei.jk.domain.Dept;
import cn.wei.jk.service.DeptService;
import cn.wei.jk.utils.Page;
import cn.wei.jk.utils.UtilFuns;
@SuppressWarnings("unchecked")
public class DeptServiceImpl implements DeptService{

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	
	
	public List find(String hql, Class entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	
	public Dept get(Class entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	
	public Page findPage(String hql, Page page, Class entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	
	public void saveOrUpdate(Dept entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			//新增
			entity.setState(1); //1启用 0停用   默认为启用
		}
		baseDao.saveOrUpdate(entity);
	}

	
	public void saveOrUpdateAll(Collection entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	
	public void deleteById(Class entityClass, Serializable id) {
		//有哪些子部门,他的父部门编号为第二个传进来的参数:id
		String hql = "from Dept where parent.id=?";
		List<Dept> list = baseDao.find(hql, Dept.class, new Object[]{id});
		if(list!= null && list.size()>0){
			for(Dept dept:list){
				deleteById(Dept.class, dept.getId());//递归调用
			}
		}
		
		baseDao.deleteById(entityClass, id); //删除父部门
	}

	
	public void delete(Class entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(Dept.class, id);
		}
		//baseDao.delete(entityClass, ids);
	}

}
