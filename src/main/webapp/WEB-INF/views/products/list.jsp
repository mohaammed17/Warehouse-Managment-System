<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<h2>Product List</h2>
<h5>Warehouse Industry: ${warehouse.industry}</h5>
<c:forEach items="${products}" var="product">
    <p>
        Name: ${product.name}<br>
        Slogan: ${product.slogan}<br>
        Flavour: ${product.flavour}<br>
        Price: ${product.price}<br>
    </p>
</c:forEach>
<a href="/newProduct?warehouse=${warehouse.getId()}">Add New Product</a>
</body>
</html>
