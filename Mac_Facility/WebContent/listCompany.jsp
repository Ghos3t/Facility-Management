<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/MAC_Facility">FACILITY Management </a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/MAC_Facility/FacilityController?action=listfacilities" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility ID</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Duration</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Type</th> 
			</tr>

 		<c:forEach items="${FACILITIES}" var="item" varStatus="status">
			<tr class="myTableRow">
		
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.idfacility}" /></td>
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.name}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.Duration}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.Type}" /></td>
            <td> <a href="/Mac_Facility/FacilityController?action=listfacilities&id=${item.idfacility}">View</a></td>
			</tr>
		</c:forEach>
 </table>

 </form>
</body>
</html>