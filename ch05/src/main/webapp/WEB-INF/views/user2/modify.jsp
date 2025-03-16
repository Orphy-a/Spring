<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>user1::register</title>
</head>
<body>
<h3>user1 수정</h3>
<a href="/ch05">처음으로</a>
<a href="/ch05/user1/list">목록이동</a>

<form action="/ch05/user1/modify" method="post">
  <table border="1">
    <tr>
      <td>아이디</td>
      <td><input type="text" name="uid" placeholder="아이디 입력" value="${user2DTO.uid}" readonly></td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name" placeholder="이름 입력" value="${user2DTO.name}"></td>
    </tr>
    <tr>
      <td>휴대폰</td>
      <td><input type="text" name="hp " placeholder="생년월일 입력" value="${user2DTO.birth}"></td>
    </tr>
    <tr>
      <td>나이</td>
      <td><input type="number" name="age" placeholder="주소 입력" value="${user2DTO.addr}"></td>
    </tr>
    <tr>
      <td colspan="2" align="right">
        <input type="submit" value="수정하기">
      </td>
    </tr>
  </table>
</form>
</body>
</html>