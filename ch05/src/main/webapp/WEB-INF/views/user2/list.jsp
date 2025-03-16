<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user2::list</title>
</head>
<body>
<h3>user2 목록</h3>
<a href="/ch05">처음으로</a>
<a href="/ch05/user2/register">등록하기</a>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생년월일</th>
        <th>주소</th>
        <th>관리</th>
    </tr>
            <c:forEach var="dto" items="${dtos}">
                <tr>
                    <td>${dto.uid}</td>
                    <td>${dto.name}</td>
                    <td>${dto.birth}</td>
                    <td>${dto.addr}</td>
                    <td>
                        <a href="/ch05/user2/modify?uid=${dto.uid}">수정</a>
                        <a href="/ch05/user2/remove">삭제</a>
                    </td>
                </tr>
            </c:forEach>

</table>
</body>
</html>