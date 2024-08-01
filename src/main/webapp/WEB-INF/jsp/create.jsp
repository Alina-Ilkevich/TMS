<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<h4>${message}</h4>
<form:form action="create" method="post" modelAttribute="user">
  <div>
    <form:label path="id"><h3>Enter id:</h3></form:label>
    <form:input path="id" type="number" value="" />
  </div>
  <div>
    <form:label path="name"><h3>Enter name:</h3></form:label>
    <form:input path="name" type="text"  value="" />
  </div>
  <div>
    <form:label path="age"><h3>Enter age:</h3></form:label>
    <form:input path="age" type="number"  value="" />
  </div>
  <div>
      <form:label path="login"><h3>Enter login:</h3></form:label>
      <form:input path="login" type="text"  value="" />
    </div>
  <div>
    <button>Send</button>
  </div>
</form:form>
</body>
</html>