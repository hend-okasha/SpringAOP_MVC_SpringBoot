<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
</head>

<body>

<h1>Order Details</h1>

<table border="1" cellpadding="10">

    <tr>
        <th>Order ID</th>
        <td>${orderId}</td>
    </tr>

    <tr>
        <th>Status</th>
        <td>${status}</td>
    </tr>

</table>

<br>

<a href="${pageContext.request.contextPath}/orders">
    Back to Orders
</a>

</body>
</html>