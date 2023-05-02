<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
   <c:when test="${!empty empsList}">
      <h1 style="color:red;text-align:center">Employees Report</h1>
      <table border="1" align="center" bgcolor="cyan">
         <tr style="color:red">
             <th>empno</th>
             <th>ename</th>
             <th>Job</th>
             <th>salary</th>
             <th>deptno</th>
             <th>Operations</th>
         </tr>
         <c:forEach var="emp" items="${empsList}">
             <tr style="color:blue">
                <td>${emp.empno }</td>
                <td>${emp.ename }</td>
                <td>${emp.job }</td>
                <td>${emp.sal }</td>
                <td>${emp.deptno }</td>
                <td>
                   <a href="edit?no=${emp.empno}"><img src="images/edit.png" width="30px" height="30px"/></a>
                   <a href="delete?no=${emp.empno}"><img src="images/delete.jpg" width="30px" height="30px"/></a>
                </td>
             </tr>
         </c:forEach>
         
      </table>
   </c:when>

   <c:otherwise>
        <h1 style="color:red;text-align:center">Employees Not Found</h1>
   </c:otherwise>
</c:choose>
<br><hr><bR><Br>
<center>
    
    <div><a href="add"><img src="images/add.jpg" width="50px" height="60px"/>Add Employee</a></div>
    <br>
    <h2 style="color:green;text-align:center">${resultMsg}</h2>
    <br><hr><bR>
    <div><a href="./"><img src="images/home.png" width="50px" height="60px"/>Home</a></div>

</center>