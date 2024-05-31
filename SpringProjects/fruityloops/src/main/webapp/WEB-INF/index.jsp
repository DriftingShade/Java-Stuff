<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruit Store</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <h1>Fruit Store</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${fruits}" var="fruit">
            <tr class="<c:if test="${fruit.name.startsWith('G')}">g-fruits</c:if>">
                <td>${fruit.name}</td>
                <td>${fruit.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
