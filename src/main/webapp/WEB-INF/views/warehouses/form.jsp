<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>

<!--
    JSP form for adding a new Warehouse.
    The form is bound to the "/addWarehouse" action, and the modelAttribute is set to "warehouse".
    Input fields are provided for ID, Industry, and Founder.
    Upon submission, the form data is sent to the "/addWarehouse" endpoint.
-->
<form:form action="/addWarehouse" modelAttribute="warehouse">
    ID:
    <form:input path="id"/><br>
    <form:errors path="id"/><br>

    Industry:
    <form:input path="industry"/><br>
    <form:errors path="industry"/><br>

    Founder:
    <form:input path="founder"/><br>
    <form:errors path="founder"/><br>

    <input type="submit"/><br>
</form:form>

</body>
</html>
