<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="email" type="java.lang.String"--%>
<%--@elvariable id="userName" type="java.lang.String"--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div>
    <h1>Пользователь успешно сохранен</h1>
    <h2>Данные пользователя:</h2>
    <p><b>Имя пользователя:</b> ${userName}</p>
    <p><b>Ваш e-mail:</b> ${email}</p>

</div>
</body>
</html>
