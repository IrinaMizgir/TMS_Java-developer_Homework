<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="email" type="java.lang.String"--%>
<%--@elvariable id="id" type="java.lang.Integer"--%>

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
<form class="mx-auto container mt-2" action="${pageContext.request.contextPath}/change-login" method="post">
    <c:if test="${id == null}">
        <div class="mb-2">
            <label for="email" class="form-label">Старый логин</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com"
                   value="${email}">
        </div>
    </c:if>
    <c:if test="${id != null}">
        <input type="hidden" id="id" name="id" value="${id}">
        <div class="mb-2">
            <label for="email" class="form-label">Новый логин</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
        </div>
    </c:if>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
