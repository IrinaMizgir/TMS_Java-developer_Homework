<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div>
    <h1>Заявка успешно сохранена</h1>
    <h2>Данные заявки:</h2>
    <p><b>Ваш e-mail:</b> ${email}</p>
    <p><b>Ваша заявка:</b> ${text}</p>
</div>
</body>
</html>
