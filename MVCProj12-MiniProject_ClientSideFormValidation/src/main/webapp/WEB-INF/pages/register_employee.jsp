<%@ page isELIgnored="false" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="JavaScript" src="js/validation.js"></script>

<h1 style="color:red;text-align:center">Register Employee Page</h1>

<frm:form modelAttribute="emp" onsubmit="return doValidations(this)">
   <table align="center" bgcolor="cyan">
   
  <%--  <p style="color:red;text-align:center">
           <frm:errors path="*"/>
        </p> --%>
       <tr>
          <td>Employee Name:: </td>
          <td><frm:input path="ename"/><frm:errors path="ename"/><span id="enameErr"></span></td>
       </tr>
        <tr>
          <td>Employee Desg:: </td>
          <td><frm:input path="job"/><frm:errors path="job"/><span id="jobErr"></span></td>
       </tr>
        <tr>
          <td>Employee salary:: </td>
          <td><frm:input path="sal"/><frm:errors path="sal"/><span id="salErr"></span></td>
       </tr>
        <tr>
           <td>Dept no.</td>
          <td>
             <frm:select path="deptno">
                <frm:options items="${deptNoInfo}"/>
             </frm:select><span id="deptnoErr"></span>
          </td>
       </tr>
        <tr>
          <td><input type="submit" value="submit"/></td>
          <td><input type="reset" value="cancel"/></td>
       </tr>
        
   </table>
</frm:form>