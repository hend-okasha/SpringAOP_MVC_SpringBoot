<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Legacy Order System</title>
</head>

<body>

<h1>Legacy Order Processing</h1>

<p>
    This request is handled by the old
    <strong>Controller interface</strong>.
</p>

<hr>

<table border="1" cellpadding="10">

    <tr>
        <th>Order ID</th>
        <td>${orderId}</td>
    </tr>

    <tr>
        <th>Processing Type</th>
        <td>Legacy Controller</td>
    </tr>

</table>

<br>

<a href="${pageContext.request.contextPath}/orders">
    Back to Dashboard
</a>

</body>
</html>