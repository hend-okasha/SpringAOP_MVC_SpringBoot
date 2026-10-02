<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>
<head>
    <title>Task Details</title>

    <style>
        * { box-sizing: border-box; }

        body {
            margin: 0;
            padding: 40px 16px;
            background: #f4f6f9;
            color: #2b3445;
            font-family: "Segoe UI", system-ui, Arial, sans-serif;
            font-size: 15px;
        }

        .card {
            max-width: 500px;
            margin: auto;
            background: #fff;
            padding: 32px;
            border: 1px solid #e3e8ef;
            border-radius: 12px;
        }

        h1 {
            margin: 0 0 16px;
            font-size: 22px;
            font-weight: 600;
        }

        .row {
            display: flex;
            padding: 14px 0;
            border-bottom: 1px solid #e3e8ef;
        }

        .row:last-of-type {
            border-bottom: none;
        }

        .label {
            width: 110px;
            color: #7a8599;
        }

        a {
            display: inline-block;
            margin-top: 20px;
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

    <h1>Task Details</h1>

    <c:choose>

        <c:when test="${task != null}">

            <div class="row">
                <span class="label">ID:</span>
                <c:out value="${task.id}"/>
            </div>

            <div class="row">
                <span class="label">Title:</span>
                <c:out value="${task.title}"/>
            </div>

            <div class="row">
                <span class="label">Priority:</span>
                <c:out value="${task.priority}"/>
            </div>

            <div class="row">
                <span class="label">Completed:</span>
                <c:out value="${task.completed}"/>
            </div>

        </c:when>

        <c:otherwise>

            <p>Task not found.</p>

        </c:otherwise>

    </c:choose>

    <a href="${pageContext.request.contextPath}/tasks">
        ← Back to Tasks
    </a>

</div>

</body>
</html>