<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<c:if test="${not empty message}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${message}"/>
    </div>
</c:if>
<form class="mx-auto container mt-2" action="${pageContext.request.contextPath}/save-request" method="post">
    <div class="mb-2">
        <label for="email" class="form-label">Введите e-mail</label>
        <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
    </div>
    <div class="mb-2">
        <label for="text" class="form-label">Заявка</label>
        <textarea class="form-control" name="text" id="text" rows="3"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
