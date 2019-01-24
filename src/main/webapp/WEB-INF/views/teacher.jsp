<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Teachers Page</title>
</head>
<body>
<h1>
	Add Teacher
</h1>

<c:url var="addAction" value="/teachers/add" ></c:url>

<form:form action="${addAction}" commandName="teacher">
<table>
	<c:if test="${!empty teacher.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="FirstName"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="secondName">
				<spring:message text="SecondName"/>
			</form:label>
		</td>
		<td>
			<form:input path="secondName" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty teacher.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Teacher"/>" />
			</c:if>
			<c:if test="${empty teacher.firstName}">
				<input type="submit"
					value="<spring:message text="Add Teacher"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Teachers List</h3>
<c:if test="${!empty listTeachers}">
	<table class="tg">
	<tr>
		<th width="80">Teacher ID</th>
		<th width="120">Teacher Name</th>
		<th width="120">Teacher Second Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTeachers}" var="tcr">
		<tr>
			<td>${tcr.id}</td>
			<td>${tcr.firstName}</td>
			<td>${tcr.secondName}</td>
			<td><a href="<c:url value='/teacher/edit/${tcr.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/teacher/remove/${tcr.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
