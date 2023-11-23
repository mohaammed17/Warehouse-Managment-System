<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>

<form:form action="/addProduct?warehouse=${warehouse}" modelAttribute="product" method="post">
    <!-- Add input fields for each property of the Product class -->
    Name: <form:input path="name"/><br>
    <form:errors path="name"/><br>

    Slogan: <form:input path="slogan"/><br>
    <form:errors path="slogan"/><br>

    Flavour: <form:input path="flavour"/><br>
    <form:errors path="flavour"/><br>

    Price: <form:input path="price"/><br>
    <form:errors path="price"/><br>

    <input type="submit" value="Add Product"/>
</form:form>

</body>
</html>
