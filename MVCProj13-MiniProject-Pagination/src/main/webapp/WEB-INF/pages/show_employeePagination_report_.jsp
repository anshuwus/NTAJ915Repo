<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<div class="container">
    <c:choose>
       <c:when test="${!empty empData.getContent()}">
             <h1 style="color:red;text-align:center">Employees Report with Pagintaion</h1>
       
             <!-- <table border="1" class="table table-striped"> -->
              <!--  <table border="1" class="table table-striped"> -->
               <table border="1" class="table table-hover">
       
              <tr class="table-danger">
                 <th>EmpNo</th>
                 <th>EmpName</th>
                 <th>Job</th>
                 <th>Salary</th>
                 <th>Operations</th>
              </tr>
              <c:forEach var="emp" items="${empData.getContent()}">
                 <tr class="table-success">
                     <td>${emp.empno}</td>
                     <td>${emp.ename}</td>
                     <td>${emp.job}</td>
                     <td>${emp.sal}</td>
                     <td>
                         <a href="edit?no=${emp.empno}"><img src="images/edit.png" width="30px" height="30px"/></a>
                         <a href="delete?no=${emp.empno}"><img src="images/delete.jpg" width="30px" height="30px"/></a>
                     </td>
                 </tr>
              </c:forEach>
           </table>
           
           
           <p style="text-align:center">
               <c:if test="${empData.hasPrevious()}">
                  <a href="paginationReport?page=${empData.getPageable().getPageNumber()-1}">previous</a> &nbsp; &nbsp;
               </c:if>
               
               <c:if test="${!empData.isFirst()}">
                   <a href="paginationReport?page=0">first</a>&nbsp;  &nbsp;
               </c:if>
               
               <c:forEach var="i" begin="1" end="${empData.getTotalPages()}" step="1">
                   [<a href="paginationReport?page=${i-1}">${i}</a>] &nbsp;  &nbsp;
               </c:forEach>
               
               <c:if test="${!empData.isLast()}">
                    <a href="paginationReport?page=${empData.getTotalPages()-1}">Last</a>&nbsp;  &nbsp;
               </c:if>
               
               <c:if test="${empData.hasNext()}">
                    <a href="paginationReport?page=${empData.getPageable().getPageNumber()+1}">next</a>
               </c:if>
           </p>
           
       </c:when>
       
       <c:otherwise>
           <h1 style="color:red ; text-align:center">Records not found</h1>
       </c:otherwise>
       
    </c:choose>
    
     <c:if test="${!empty resultMsg}">
         <h3 style="color:green;text-align:center">${resultMsg}</h3>
     </c:if>
     <br><br><hr>
     <h3 style="text-align:center"><a href="./"><img src="images/home.png" width="50px" height="60px"/>Home</a></h3>
     <br><hr>
     <h3 style="text-align:center"><a href="add"><img src="images/add.jpg" width="50px" height="60px"/>Add Employee</a></h3>
     
</div>