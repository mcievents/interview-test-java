<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Task List</title>

    <style type="text/css">
        table {
            border: 1px solid black;
            width: 100%;
            border-collapse: collapse;
        }

        td, th {
            padding: 0.2em 0.5em;
            border: 1px solid gray;
        }
    </style>
</head>
<body>

<h1>Tasks</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Assignee</th>
        <th>Due</th>
        <th>Completed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.tasks}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty task.assignee}">
                        <a href="mailto:${task.assignee.email}">${task.assignee.name}</a>
                    </c:when>
                    <c:otherwise>
                        <em>none</em>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <fmt:formatDate value="${task.due}" pattern="dd-MMM-yyyy hh:mm a"/>
            </td>
            <td>
                <fmt:formatDate value="${task.completedAt}" pattern="dd-MMM-yyyy hh:mm a"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>