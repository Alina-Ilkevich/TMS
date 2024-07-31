<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>
    <c:if test="${message}">
        <h4>ID: ${user.id}</h4>
        <h4>Name: ${user.name}</h4>
        <h4>Age: ${user.age}</h4>
        <h4>Login: ${user.login}</h4>

    </c:if>
    <c:if test="${!message}">
        <h2>${message}</h2>

    </c:if>


</body>
</html>