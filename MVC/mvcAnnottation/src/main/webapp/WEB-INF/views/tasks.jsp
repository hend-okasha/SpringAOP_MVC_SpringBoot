<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>
<head>
    <title>Tasks</title>

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

        .container {
            max-width: 900px;
            margin: auto;
            background: #fff;
            padding: 32px;
            border: 1px solid #e3e8ef;
            border-radius: 12px;
        }

        h1 {
            margin: 0 0 24px;
            font-size: 22px;
            font-weight: 600;
        }

        .actions {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            gap: 10px;
            margin-bottom: 24px;
        }

        .actions a,
        .actions button {
            padding: 8px 16px;
            border: 1px solid #5b7db1;
            border-radius: 8px;
            background: #5b7db1;
            color: #fff;
            font: inherit;
            text-decoration: none;
            cursor: pointer;
        }

        .actions a:hover,
        .actions button:hover {
            background: #4a6a9c;
        }

        .actions a.secondary,
        .actions button {
            background: #fff;
            color: #5b7db1;
            border-color: #e3e8ef;
        }

        .actions a.secondary:hover,
        .actions button:hover {
            background: #eaf0f9;
        }

        .actions form {
            display: flex;
            gap: 8px;
            margin-left: auto;
        }

        select {
            padding: 8px 10px;
            border: 1px solid #e3e8ef;
            border-radius: 8px;
            background: #fff;
            color: #2b3445;
            font: inherit;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: left;
            padding: 10px 12px;
            font-size: 13px;
            font-weight: 500;
            color: #7a8599;
            border-bottom: 1px solid #e3e8ef;
        }

        td {
            padding: 14px 12px;
            border-bottom: 1px solid #e3e8ef;
        }

        tr:last-child td {
            border-bottom: none;
        }

        tr:hover td {
            background: #fafbfd;
        }

        td a {
            color: #5b7db1;
            text-decoration: none;
        }

        td a:hover {
            text-decoration: underline;
        }

        .badge {
            display: inline-block;
            padding: 2px 10px;
            border-radius: 999px;
            font-size: 13px;
            background: #eaf0f9;
            color: #5b7db1;
        }

        .badge.LOW    { background: #e8f3ec; color: #3f7a55; }
        .badge.MEDIUM { background: #fdf3e1; color: #94661a; }
        .badge.HIGH   { background: #fbeaea; color: #a64545; }

        .completed,
        .pending {
            display: inline-flex;
            align-items: center;
            gap: 6px;
        }

        .completed::before,
        .pending::before {
            content: "";
            width: 8px;
            height: 8px;
            border-radius: 50%;
        }

        .completed::before { background: #5fa77a; }
        .pending::before   { background: #d9a441; }

        @media (max-width: 600px) {
            .container { padding: 20px; }
            .actions form { margin-left: 0; width: 100%; }
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Task Management</h1>

    <div class="actions">

        <a href="${pageContext.request.contextPath}/tasks/new">
            + Create New Task
        </a>

        <a class="secondary" href="${pageContext.request.contextPath}/tasks">
            Show All
        </a>

        <form action="${pageContext.request.contextPath}/tasks/search"
              method="get">

            <select name="priority">

                <option value="LOW">LOW</option>
                <option value="MEDIUM">MEDIUM</option>
                <option value="HIGH">HIGH</option>

            </select>

            <button type="submit">
                Search
            </button>

        </form>

    </div>


    <table>

        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Priority</th>
            <th>Status</th>
            <th>Action</th>
        </tr>

        <c:forEach var="task" items="${tasks}">

            <tr>

                <td><c:out value="${task.id}"/></td>

                <td><c:out value="${task.title}"/></td>

                <td>
                    <span class="badge ${task.priority}">
                        <c:out value="${task.priority}"/>
                    </span>
                </td>

                <td>

                    <c:choose>

                        <c:when test="${task.completed}">
                            <span class="completed">Completed</span>
                        </c:when>

                        <c:otherwise>
                            <span class="pending">Pending</span>
                        </c:otherwise>

                    </c:choose>

                </td>

                <td>
                    <a href="${pageContext.request.contextPath}/tasks/${task.id}">
                        View Details
                    </a>
                </td>

            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>