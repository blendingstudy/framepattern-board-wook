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
                    <h5 style="background-color:darksalmon">사용자정보</h5>
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
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 style="background-color:darksalmon">댓글기능</h5>
                            <form method="post" action="/saveComment/${post.id}" modelAttribute="postComment" >
                                <input name="comment" style="width:90%"/>
                                <button type="submit" class="btn btn-primary">댓글등록</button>
                            </form>
                            <table class="table table-hover">
                                <tbody>
                                    <c:forEach items="${page.postsComment}" var="comment">
                                        <tr>
                                            <td style="width:70%">
                                                ${comment.comment}
                                            </td>
                                            <td style="width:20%">
                                                <fmt:formatDate value="${comment.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                            <td style="width:10%">
                                                <a href="/delete/comment/${post.id}&${comment.id}" class="card-link">삭제</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 style="background-color:darksalmon">파일 업로드</h5>
                            <form action="/upload/${post.id}" method="post" enctype="multipart/form-data">
                                <fieldset>
                                   <p>파일명 : <input type="file" name="file"></p>
                                   <p><input type="submit" value="upload"></p>	 	
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>