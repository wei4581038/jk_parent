package cn.wei.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.wei.jk.domain.Dept;
import cn.wei.jk.utils.Page;

public interface DeptService {
	//查询所有，带条件查询
	public  List find(String hql, Class entityClass, Object[] params);
	//获取一条记录
	public  Dept get(Class entityClass, Serializable id);
	//分页查询，将数据封装到一个page分页工具类对象
	public  Page findPage(String hql, Page page, Class entityClass, Object[] params);
	
	//新增和修改保存
	public  void saveOrUpdate(Dept entity);
	//批量新增和修改保存
	public  void saveOrUpdateAll(Collection entitys);
	
	//单条删除，按id
	public  void deleteById(Class entityClass, Serializable id);
	//批量删除
	public  void delete(Class entityClass, Serializable[] ids);

}
