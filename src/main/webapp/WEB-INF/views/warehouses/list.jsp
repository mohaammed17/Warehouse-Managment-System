<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<c:forEach items="${warehouses}" var="warehouse">
    <p>Industry: ${warehouse.industry}</p>
    <p>Founder: ${warehouse.founder}</p>
    <p><a href="/products?warehouse=${warehouse.id}">Products</a></p>
</c:forEach>
</body>
</html>