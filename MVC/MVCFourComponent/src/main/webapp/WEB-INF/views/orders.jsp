<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order Management</title>
</head>

<body>

<h1>Order Management System</h1>

<hr>

<h2>Dashboard</h2>

<p>${message}</p>

<p>
    Total Orders:
    <strong>${count}</strong>
</p>

<hr>

<h3>Available Operations</h3>

<ul>
    <li>
        <a href="${pageContext.request.contextPath}/orders/details?id=101">
            View Order Details
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/orders/legacy?id=202">
            Legacy Order
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/orders/confirm?id=303">
            Confirm Order
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/orders/raw">
            Raw Response
        </a>
    </li>
</ul>

</body>
</html>