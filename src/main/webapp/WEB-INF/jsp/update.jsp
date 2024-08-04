<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change data</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="student">
  <h4>${message}</h4>
  <div>
    <form:label path="id"><h3>Enter id:</h3></form:label>
    <form:input path="id" type="number" id="id" value="" />
  </div>
  <div>
      <form:label path="name"><h3>Enter name:</h3></form:label>
      <form:input path="name" type="text"  value="" />
    </div>
    <div>
        <form:label path="surname"><h3>Enter surname:</h3></form:label>
        <form:input path="surname" type="text"  value="" />
      </div>
    <div>
      <form:label path="groupNumber"><h3>Enter group number:</h3></form:label>
      <form:input path="groupNumber" type="number"  value="" />
    </div>
    <div>
        <form:label path="payment"><h3>Enter payment:</h3></form:label>
        <form:input path="payment" type="text"  value="" />
      </div>
  <div>
    <button>Send</button>
  </div>
</form:form>
</body>
</html>