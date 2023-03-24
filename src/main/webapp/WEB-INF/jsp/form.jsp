<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="common.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <meta charset="UTF-8" />
</head>
<body>
    <div class="container">
        <div class="row mt-2">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <form:form method="post" action="/save" modelAttribute="post" >
                            <form:hidden path="id"/>
                            <div class="mb-3">
                                <label for="userName" class="form-label">이름</label>
                                <form:input path="userName" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="userName" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="birthday" class="form-label">생년월일</label>
                                <form:input type="date" path="birthday" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="birthday" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="phoneNumber" class="form-label">휴대폰번호</label>
                                <form:input path="phoneNumber" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="phoneNumber" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="walletAddress" class="form-label">지갑주소</label>
                                <form:input path="walletAddress" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="walletAddress" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="balance" class="form-label">잔액</label>
                                <form:input path="balance" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="balance" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="bank" class="form-label">은행명</label>
                                <form:input path="bank" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="bank" />
                                </p>
                            </div>
                            <div class="mb-3">
                                <label for="accountNumber" class="form-label">계좌번호</label>
                                <form:input path="accountNumber" class="form-control"/>
                                <p class="error px-2">
                                    <form:errors path="accountNumber" />
                                </p>
                            </div>
                            <a href="/" class="btn btn-secondary me-2">취소</a>
                            <button type="submit" class="btn btn-primary">저장</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>