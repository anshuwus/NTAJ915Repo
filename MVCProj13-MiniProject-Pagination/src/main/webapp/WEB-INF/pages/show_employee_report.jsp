<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<div class="container">
    <c:choose>
   <c:when test="${!empty empsList}">
      <h1 style="color:red;text-align:center">Employees Report</h1>
      <table border="1" align="center" class="table table-striped table-hover">
         <tr class="table-danger">
             <th>empno</th>
             <th>ename</th>
             <th>Job</th>
             <th>salary</th>
             <th>deptno</th>
             <th>Operations</th>
         </tr>
         <c:forEach var="emp" items="${empsList}">
             <tr class="table-success">
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
</div>
<br><hr><bR><Br>
<center>
    
    <div><a href="add"><img src="images/add.jpg" width="50px" height="60px"/>Add Employee</a></div>
    <br>
    <h2 style="color:green;text-align:center">${resultMsg}</h2>
    <br><hr><bR>
    <div><a href="./"><img src="images/home.png" width="50px" height="60px"/>Home</a></div>

</center>