<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information About MAR</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">

        <div class="header_resize">
      <div class="logo"><h1>MAVERICK ACTIVITY CENTER</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
    
      
      <table border="1" class="myTable"> 
     
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 130px; ">Facility</th>
				<th class="myTableHead" style="width: 130px; ">Name</th>
				<th class="myTableHead" style="width: 74px;  ">Description</th> 
				<th class="myTableHead" style="width: 74px;  ">ReportedBy</th> 
				<th class="myTableHead" style="width: 74px;  ">Date</th> 
				<th class="myTableHead" style="width: 74px;  ">MAR Number</th> 
				<th class="myTableHead" style="width: 74px;  ">assigned_to</th>
				
			</tr>
			<c:forEach items="${FACILITIES}" var="item">
			<tr class="myTableRow"> 
				<td class="myTableCell" style="width: 130px; "><c:out value="${item.getFacility_type()}" /></td> 
				<td class="myTableCell" style="width: 130px; "><c:out value="${item.getFacility_name()}" /></td>
				<td class="myTableCell" style="width: 74px;  "><c:out value="${item.getDescription()}" /></td>
				<td class="myTableCell" style="width: 74px;  "><c:out value="${item.getDescription()}" /></td>
				<td class="myTableCell" style="width: 74px;  "><c:out value="${item.getDate()}" /></td>
				<td class="myTableCell" style="width: 74px;  "><c:out value="${item.getMar()}" /></td>
				<td class="myTableCell" style="width: 74px;  "><c:out value="${item.getAssigned_to()}" /></td>
		   </tr>
		   </c:forEach>
		   </a>
		   
</table>
</a>
</body>
</html>