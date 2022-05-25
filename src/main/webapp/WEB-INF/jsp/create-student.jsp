<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<%--@elvariable id="student" type="ru.azor.springhomework.entities.Student"--%>
<form:form action="create" modelAttribute="student">
    <form:hidden path="id" value="${student.id}"/>
    Name: <form:input path="name"/>
    Age: <form:input path="age"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>