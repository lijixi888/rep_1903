<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
   table{
        width:240px;
        border:3px solid #ccc;
        border-collapse: collapse;
        margin:auto;
        margin-top:20px;
   }
   
   table td{
       border:1px solid #ccc;
   }

</style>
</head>
<body>
     <h2 align="center">修改员工</h2>
      <fm:form modelAttribute="emp"  name="updateForm"
       action="${pageContext.request.contextPath}/emp/update"  method="POST">
       <input type="hidden" name="_method" value="PUT"/>
          <p align="center">
               <fm:errors path="*" cssStyle="color:red"></fm:errors>
          </p>
          <fm:hidden  value="${emp.empno}" path="empno"/>
         <table>
             <tr>
                <td>姓名</td>
                <td>
                   <fm:input path="ename"  value="${emp.ename}"/>
                </td>
             </tr>
              <tr>
                <td>性别</td>
                <td>
             
                <!-- 依据模型属性的内容自动选择 -->
                <fm:radiobuttons path="esex" items="${map}"/>
                </td>
             </tr>
             <tr>
               <td>年龄</td>
               <td>
                  <fm:input path="eage"  value="${emp.eage}"/>
               </td>
             </tr>
            <tr>
                <td>薪资</td>
                <td>
                  <fm:input path="esalary"  value="${emp.esalary}"/>
                </td>
            </tr>
            <tr>
               <td>部门</td>
               <td>
                  
                  <fm:select path="dept.deptno" items="${depts}"
                    itemLabel="dname"  itemValue="deptno"
                    ></fm:select>
               </td>          
            </tr>
            <tr>
                <td>经理</td>
                <td>
                  <fm:select  path="mgr.empno" items="${mgrs}" itemLabel="ename" itemValue="empno" ></fm:select>
                  
                </td>
            </tr>
            <tr align="center">
               <td colspan="2">
                  <input type="submit"  value="保存"/>
                  <input type="button" value="重置" onclick="doReset()"/>
               </td>
            </tr>
         </table>
      </fm:form>
     <script type="text/javascript">
   //表单重置函数
     function doReset(){
  	    //document.addForm.reset();
  	    document.updateForm.ename.value="";
  	     var ck = document.getElementById("esex2");
           ck.checked = true;
  	    document.updateForm.eage.value="";
  	    document.updateForm.esalary.value="";
  	    document.updateForm.deptno.value="d001";
  	    document.updateForm.mgrno.value="e001";        	    
    }
     
     </script>
</body>
</html>