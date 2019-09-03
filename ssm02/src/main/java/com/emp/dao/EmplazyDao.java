package com.emp.dao;

import java.util.List;

import javax.jws.Oneway;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.emp.entity.Emp;
//懒加载的局限性，如果是前后分离的开发方式，将数据封装成json对象返回给前端游览器的，就不能进行懒加载
//使用懒加方式查询
public interface EmplazyDao {
	@Select("select empno,ename,esex,eage,esalary,deptno,mgrno from t_emp "
			+ " where empno=#{empno}")
	@Results(id="empMapper",value={
			@Result(id=true,column="empno",property="empno"),
			@Result(column="ename",property="ename"),
			@Result(column="esex",property="esex"),
			@Result(column="eage",property="eage"),
			@Result(column="esalary",property="esalary"),
			@Result(column="deptno",property="dept",
			one=@One(select="com.emp.dao.DeptDao.selectId",
			fetchType=FetchType.LAZY)),
			@Result(column="mgrno",property="mgr",
			one=@One(select="com.emp.dao.EmplazyDao.queryById",
					fetchType=FetchType.LAZY))
	})
	//many=@many 多个
   Emp queryById(@Param("empno")String empno);
	
	@Select("select empno,ename,esex,eage,esalary,deptno,mgrno from t_emp ")
	@ResultMap("empMapper")
	List<Emp> queryAll();
	
	//依据姓名模糊查询
	@Select("select empno,ename,esex,eage,esalary,deptno,mgrno "
			+ "from t_emp where INSTR(ename,#{ename})>0")//优化
			//+ "where e.ename like CONCAT('%',#{e.enam},'%')")
	@ResultMap("empMapper")
	List<Emp> queryListName(@Param("ename")String ename);
	//添加员工
	@Insert("insert into t_emp values(#{empno},#{ename},#{esex},#{eage},#{esalary},"
			+ "#{dept.deptno},#{mgr.empno})")
	void addEmp(Emp emp);
	//修改员工
	@Update("update t_emp set ename=#{ename},esex=#{esex},eage=#{eage},"
			+ "esalary=#{esalary},deptno=#{dept.deptno},mgrno=#{mgr.empno}"
			+ " where empno=#{empno}")
	void updateEmp(Emp emp);
	//根据员工编号删除员工
	@Delete("delete from t_emp where empno=#{empno}")
  	void deleteEmp(@Param("empno")String empno);
	
	
	//查询出所有的经理
	@Select("select DISTINCT m.empno,m.ename"
			+ " from t_emp m inner join t_emp e on m.empno=e.mgrno"
			+ " where m.deptno IS NOT NULL")
	@ResultMap("empMapper")
	List<Emp> queryMgrs();
	
	//根据部门编号查询部下员工
	@Select("select empno,ename,esex,eage,esalary,deptno,mgrno"
			+ " from t_emp where deptno=#{deptno}")
	@ResultMap("empMapper")
	public List<Emp> selectBu(@Param("deptno")String deptno);
	
	

}
