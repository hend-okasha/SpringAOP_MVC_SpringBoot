<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>
<head>
    <title>Error</title>

    <style>
        body {
            margin: 0;
            padding: 40px 16px;
            background: #f4f6f9;
            color: #2b3445;
            font-family: "Segoe UI", system-ui, Arial, sans-serif;
            font-size: 15px;
        }

        .card {
            max-width: 480px;
            margin: auto;
            background: #fff;
            padding: 32px;
            border: 1px solid #e3e8ef;
            border-radius: 12px;
        }

        h1 {
            margin: 0 0 12px;
            font-size: 22px;
            font-weight: 600;
        }

        p {
            color: #b85450;
        }

        a {
            display: inline-block;
            margin-top: 16px;
            color: #5b7db1;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<div class="card">

    <h1>Task Not Found</h1>

    <p><c:out value="${error}"/></p>

    <a href="${pageContext.request.contextPath}/tasks">
        Back to Tasks
    </a>

</div>

</body>
</html>