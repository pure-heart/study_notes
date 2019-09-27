<html xmlns:th="http://www.thymeleaf.org">
<body>
<h2>Hello World!</h2>
<table>
    <tr>
        <th>id</th>
        <th>uname</th>
        <th>age</th>
        <th>remark</th>
        <th>createDate</th>
    </tr>
    <tr th:each="user:${users}">
        <td th:text="${user.id}"></td>
        <td th:text="${user.uname}"></td>
        <td th:text="${user.age}"></td>
        <td th:text="${user.remark}"></td>
        <td th:text="${user.createDate}"></td>
    </tr>
</table>
</body>
</html>
