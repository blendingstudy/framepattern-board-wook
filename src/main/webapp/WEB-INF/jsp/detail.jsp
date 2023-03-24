<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row mt-2">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                    <c:choose>
                        <c:when test="${post != null}">
                            <h5 class="card-title">userName : ${post.userName}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">createdAt : <fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></h6>
                            <p class="card-text mt-3">birthday : ${post.birthday}</p>
                            <p class="card-text mt-3">phoneNumber : ${post.phoneNumber}</p>
                            <p class="card-text mt-3">walletAddress : ${post.walletAddress}</p>
                            <p class="card-text mt-3">balance : ${post.balance}</p>
                            <p class="card-text mt-3">bank : ${post.bank}</p>
                            <p class="card-text mt-3">accountNumber : ${post.accountNumber}</p>
                            <a href="/form/${post.id}" class="card-link">수정</a>
                            <a href="/delete/${post.id}" class="card-link">삭제</a>
                            <a href="/" class="card-link">목록</a>
                        </c:when>
                        <c:otherwise>
                            작성글이 존재하지 않습니다.
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="card" >
                    <form:form method="postComment" action="/saveComment" modelAttribute="postComment" >
                        <div class="col-12">
                            <input type="text" style="width:90%">
                            <button type="submit" class="btn btn-primary">댓글등록</button>
                        </div>
                    </form:form>
                    <c:forEach items="${page.comments}" var="postComment">
                        <span>
                            <p scope="row">${postComment.id}</p>
                            <p>${postComment.userName}</a></p>
                            <p>${postComment.content}</a></p>
                            <p><fmt:formatDate value="${postComment.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                            <a href="/delete/comment/${postComment.id}" class="card-link">삭제</a>
                        </span>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>
</html>