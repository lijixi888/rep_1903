package com.emp.dao;

import java.util.List;



import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

import com.emp.entity.Dept;

public interface DeptDao {
    @Select("select deptno,dname,location from t_dept")
    @Results(id="seleMM",value={
    		@Result(id=true,column="deptno",property="deptno"),
    		@Result(column="dname",property="dname"),
    		@Result(column="location",property="location")	
    })
	List<Dept> selectAll();
    @Select("select deptno,dname,location from t_dept where deptno=#{deptno}")
    @ResultMap("seleMM")
    Dept selectId(@Param("deptno")String Dept);
    //增加
    @Insert("insert into t_dept value(#{deptno},#{dname},#{location})")
    void addDept(Dept dept);
    //修改 
    @Update("update t_depe set dname=#{dname},location=#{location} where deptno=#{deptno}")
    void updateDept(Dept dept);
    //删除 根据部门编号删除
    @Delete("delete from t_depe where deptno=#{deptno}")
    void deleteDept(@Param("deptno")String deptno);
    
}
