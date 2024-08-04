<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student info</title>
</head>

<body>
    <c:forEach items="${student}" var="group">
        ${group}
        <br>
    </c:forEach>
    <br>
</body>
</html>