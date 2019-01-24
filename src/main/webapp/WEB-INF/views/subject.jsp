<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Subjects Page</title>
</head>
<body>
<h1>
	Add Subject
</h1>

<c:url var="addAction" value="/subject/add" ></c:url>

<form:form action="${addAction}" commandName="subject">
<table>
	<c:if test="${!empty subject.name}">
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
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hoursCountPerSemestr">
				<spring:message text="HoursCountPerSemestr"/>
			</form:label>
		</td>
		<td>
			<form:input path="hoursCountPerSemestr" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty subject.name}">
				<input type="submit"
					value="<spring:message text="Edit Subject"/>" />
			</c:if>
			<c:if test="${empty subject.name}">
				<input type="submit"
					value="<spring:message text="Add Subject"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Subjects List</h3>
<c:if test="${!empty listSubjects}">
	<table class="tg">
	<tr>
		<th width="80">Subject ID</th>
		<th width="120">Subject Name</th>
		<th width="120">Subject Description</th>
		<th width="100">Subject Count</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listSubjects}" var="sub">
		<tr>
			<td>${sub.id}</td>
			<td>${sub.name}</td>
			<td>${sub.description}</td>
			<td>${sub.hoursCountPerSemestr}</td>
			<td><a href="<c:url value='/subject/edit/${sub.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/subject/remove/${sub.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
