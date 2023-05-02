<%@ page isELIgnored="false" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<h1 style="color:red;text-align:center">Register Employee Page</h1>

<frm:form modelAttribute="emp">
   <table align="center" bgcolor="cyan">
       <tr>
          <td>Employee Name:: </td>
          <td><frm:input path="ename"/></td>
       </tr>
        <tr>
          <td>Employee Desg:: </td>
          <td><frm:input path="job"/></td>
       </tr>
        <tr>
          <td>Employee salary:: </td>
          <td><frm:input path="sal"/></td>
       </tr>
        
       <tr>
          <td>Dept no.</td>
          <td>
             <frm:select path="deptno">
                <frm:options items="${deptNoInfo}"/>
             </frm:select>
          </td>
       </tr>
        <tr>
          <td><input type="submit" value="submit"/></td>
          <td><input type="reset" value="cancel"/></td>
       </tr>
        
   </table>
</frm:form>