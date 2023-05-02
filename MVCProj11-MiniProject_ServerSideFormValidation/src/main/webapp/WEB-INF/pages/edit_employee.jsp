<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<link rel="stylesheet" type="text/css" href="css/style.css">


<h1 style="color:blue;text-align:center">Student Registration Form</h1>
  <frm:form modelAttribute="emp" action="update">
     <table border="0" bgcolor="cyan" align="center">
       <%--  <p style="color:red;text-align:center">
           <frm:errors path="*"/>
        </p> --%>
        <tr>
        <td>Employee no:</td>
        <td><frm:input path="empno" readonly="true"/></td>
     </tr>
     <tr>
        <td>Employee Name:</td>
        <td><frm:input path="ename"/><frm:errors path="ename"/></td>
     </tr>
      <tr>
        <td>Job:</td>
        <td><frm:input path="job"/><frm:errors path="job"/></td>
     </tr>
      <tr>
        <td>Salary:</td>
        <td><frm:input path="sal"/><frm:errors path="sal"/></td>
     </tr>
     <tr>
        <td>DeptNo:</td>
        <td>
         <frm:select path="deptno">
            <frm:options items="${deptNoInfo}"/>
          </frm:select>
        </td>    
     </tr>
     <tr>
        <td><input type="submit" value="Update"/></td>
        <td><input type="reset" value="cancel"/></td>
     </tr>
     
     </table>
  </frm:form>