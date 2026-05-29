<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Pagination Example</title>
  </head>
  <body>
    <ui:menubarHO>
      <h1>페이지네이션 ${pageInfo.currentPage}번 페이지</h1>
      <a href="/burgerstack/example">인덱스로</a>
      <ui:pagination pageInfo="${pageInfo}" />
    </ui:menubarHO>
  </body>
</html>
