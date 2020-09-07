<%@ taglib prefix ="form" uri ="http://www.springframework.org/tags/form" %>
<%@ taglib prefix ="C" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Custom Login page
</title>
<style>

.failed
{color:red}
</style>

</head>
<body>
<h3>My custom Login Form</h3>
<form:form action ="${pageContext.request.contextPath}/authenticateTheUser" method ="POST"> 

<C:if test= "${param.error != null}" >
<i class ="failed"> Sorry! You Entered an invalid username or password</i>
</C:if>
<p>
UserName : <input type="text" name ="username">
</p>
<p>
Password : <input type="text" name ="password"></p>
<input type="submit" value ="Login">

</form:form>
</body>
</html>