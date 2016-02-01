<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
    Greeting : ${greeting}
    This is a welcome page.
    
    <h1><a href="<c:url value="/admin" />">Admin</a></h1>
    <h1><a href="<c:url value="/db" />">DBA</a></h1>
    <h1><a href="<c:url value="/user" />">User</a></h1>
</body>
</html>