<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
  <h1>페이지네이션 ${pageInfo.currentPage}번 페이지</h1>
  <a href="/burgerstack/example">인덱스로</a>
  <ui:pagination pageInfo="${pageInfo}" />
</t:layout>
