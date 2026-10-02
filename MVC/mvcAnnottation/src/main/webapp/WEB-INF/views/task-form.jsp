<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create Task</title>

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
            max-width: 480px;
            margin: auto;
            background: #fff;
            padding: 32px;
            border: 1px solid #e3e8ef;
            border-radius: 12px;
        }

        h1 {
            margin: 0 0 8px;
            font-size: 22px;
            font-weight: 600;
        }

        label {
            display: block;
            margin-top: 18px;
            font-weight: 500;
        }

        input, select {
            width: 100%;
            padding: 9px 10px;
            margin-top: 6px;
            border: 1px solid #e3e8ef;
            border-radius: 8px;
            background: #fff;
            color: #2b3445;
            font: inherit;
        }

        input:focus, select:focus {
            outline: 2px solid #c9d8ee;
            border-color: #5b7db1;
        }

        .checkbox {
            width: auto;
            margin-right: 6px;
        }

        .error {
            display: block;
            margin-top: 4px;
            color: #b85450;
            font-size: 13px;
        }

        button {
            margin-top: 24px;
            padding: 9px 20px;
            border: none;
            border-radius: 8px;
            background: #5b7db1;
            color: #fff;
            font: inherit;
            cursor: pointer;
        }

        button:hover {
            background: #4a6a9c;
        }

        .back {
            display: inline-block;
            margin-top: 20px;
            color: #5b7db1;
            text-decoration: none;
        }

        .back:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Create New Task</h1>

    <form:form method="post"
               action="${pageContext.request.contextPath}/tasks"
               modelAttribute="task">

        <label>Title:</label>

        <form:input path="title"/>

        <form:errors path="title" cssClass="error"/>


        <label>Priority:</label>

        <form:select path="priority">

            <form:option value="" label="-- Select Priority --"/>
            <form:option value="LOW" label="LOW"/>
            <form:option value="MEDIUM" label="MEDIUM"/>
            <form:option value="HIGH" label="HIGH"/>

        </form:select>

        <form:errors path="priority" cssClass="error"/>


        <label>
            <form:checkbox path="completed" cssClass="checkbox"/>
            Completed
        </label>


        <button type="submit">
            Create Task
        </button>

    </form:form>

    <br>

    <a class="back"
       href="${pageContext.request.contextPath}/tasks">
        ← Back to Tasks
    </a>

</div>

</body>
</html>