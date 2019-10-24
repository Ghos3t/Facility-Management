<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserting New Facility</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="FacilityADD" action="/MAC_Facility/FacilityController?action=ADDFacility" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Facility ID (*): </td>
    <td> <input name="idfacility"  type="text" maxlength="16"> </td>
  	<td> <input name="facilityIDerror"  value="<c:out value='${errorMsgs.setFacilityIDError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Facility Name (*): </td>
    <td> <input name="facility_name" type="text" >  </td>
 	<td> <input name="facilityerror"  value="<c:out value='${errorMsgs.setFacilityNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Duration: </td>
    <td> <input name="type" type="text" maxlength="16">  </td>
  	<td> <input name="typeerror"  value="<c:out value='${errorMsgs.setFacilityTypeError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Type (*): </td>
    <td> <input name="venue"  type="text" maxlength="45">  </td>
  	<td> <input name=""  type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="ADDFacility" type="hidden">
    <input type="submit" value="Insert Facility">
   
    </form>
</td>
</tr>
</table>

</body>
</html>