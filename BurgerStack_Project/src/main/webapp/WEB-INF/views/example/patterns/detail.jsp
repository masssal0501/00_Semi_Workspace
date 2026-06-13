<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="datetime" uri="/WEB-INF/tld/datetime.tld" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="display" tagdir="/WEB-INF/tags/display" %>

<%--
  상세 페이지 패턴 예제입니다.

  기본 구조:
  1. <layout:Page>는 상세/폼처럼 자유롭게 본문을 조립하는 페이지 래퍼입니다.
  2. <layout:Page>에서 actions 슬롯을 쓰면 반드시 <jsp:body>를 명시합니다.
     JSP 컴파일러가 jsp:attribute 뒤의 본문을 안정적으로 해석하도록 하기 위한 정책입니다.
  3. 상세의 라벨/값 영역은 layout:Section + common:FieldList + layout:FieldRow 조합을 사용합니다.
  4. 상세 하단에 관련 목록이 있으면 layout:TableSection + table:Table 조합을 사용합니다.

  필요한 taglib 지시어:
  - layout 컴포넌트: <%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
  - common 컴포넌트: <%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
  - table 컴포넌트: <%@ taglib prefix="table" tagdir="/WEB-INF/tags/table" %>
  - display 컴포넌트: <%@ taglib prefix="display" tagdir="/WEB-INF/tags/display" %>

  모델 예시:
  - detail : 상세 DTO
  - detail.history : 상세 화면 안에 같이 보여줄 이력 목록 DTO
--%>

<c:url var="listUrl" value="/example/patterns/list" />
<c:url var="formUrl" value="/example/patterns/form" />

<t:layout>
  <layout:Page title="상세 페이지 패턴" description="읽기 전용 정보와 관련 이력을 함께 보여주는 표준 상세 화면 예제입니다.">
    <jsp:attribute name="actions">
      <%-- 헤더 오른쪽에는 목록 복귀, 수정 이동 같은 페이지 단위 액션을 둡니다. --%>
      <common:ReturnLink href="${listUrl}">목록으로</common:ReturnLink>
      <a href="${formUrl}" class="btn btn-primary ml-2">수정</a>
    </jsp:attribute>

    <jsp:body>
      <layout:Section title="기본 정보" description="FieldRow는 라벨과 값을 3:9 그리드로 맞추는 상세/폼 공통 행입니다.">
        <common:FieldList>
          <%-- 단순 텍스트 값은 FieldRow body에 바로 출력합니다. --%>
          <layout:FieldRow label="재고 코드">${detail.inventoryCode}</layout:FieldRow>
          <layout:FieldRow label="점포명">${detail.storeName}</layout:FieldRow>
          <layout:FieldRow label="자재 코드">${detail.materialCode}</layout:FieldRow>
          <layout:FieldRow label="자재명">${detail.materialName}</layout:FieldRow>

          <%-- 도메인 코드 값은 display 태그로 라벨 표현을 통일합니다. --%>
          <layout:FieldRow label="자재 유형">
            <display:MaterialTypeLabel value="${detail.materialType}" />
          </layout:FieldRow>

          <%-- 숫자 값은 상세 영역에서는 필요한 단위만 직접 붙이고, 테이블에서는 NumberCell을 사용합니다. --%>
          <layout:FieldRow label="현재 수량">${detail.currentQuantity}</layout:FieldRow>
          <layout:FieldRow label="안전재고 수량">${detail.safetyQuantity}</layout:FieldRow>

          <%-- 날짜/시간은 datetime tld를 사용해 포맷을 통일합니다. --%>
          <layout:FieldRow label="마지막 갱신">
            <c:out value="${datetime:formatDateTime(detail.updatedAt)}" />
          </layout:FieldRow>

          <%-- 비어 있을 수 있는 값은 화면에서 직접 fallback을 명시합니다. --%>
          <layout:FieldRow label="메모">
            <c:choose>
              <c:when test="${empty detail.memo}">
                <span class="text-muted">-</span>
              </c:when>
              <c:otherwise>
                <c:out value="${detail.memo}" />
              </c:otherwise>
            </c:choose>
          </layout:FieldRow>
        </common:FieldList>
      </layout:Section>

      <layout:TableSection title="최근 변동 이력" description="상세 안의 관련 목록은 TableSection으로 카드와 테이블 여백을 맞춥니다.">
        <table:Table isEmpty="${empty detail.history}" emptyMessage="변동 이력이 없습니다.">
          <jsp:attribute name="thead">
            <tr>
              <th class="text-right">처리 일시</th>
              <th class="text-center">변동 유형</th>
              <th class="text-right">변동 수량</th>
              <th class="text-right">변동 후 수량</th>
              <th>사유</th>
            </tr>
          </jsp:attribute>

          <jsp:attribute name="tbody">
            <c:forEach var="item" items="${detail.history}">
              <table:TableRow>
                <table:DateTimeCell value="${item.createdAt}" />
                <table:FitCell>
                  <display:InventoryTransactionTypeBadge value="${item.transactionType}" />
                </table:FitCell>
                <table:DeltaCell value="${item.changedQuantity}" />
                <table:NumberCell value="${item.afterQuantity}" />
                <table:TextCell value="${item.reason}" />
              </table:TableRow>
            </c:forEach>
          </jsp:attribute>
        </table:Table>
      </layout:TableSection>

      <common:Actions>
        <%-- 하단 액션은 사용자가 스크롤 후에도 다음 행동을 바로 선택할 수 있게 둡니다. --%>
        <common:ReturnLink href="${listUrl}">목록으로</common:ReturnLink>
        <a href="${formUrl}" class="btn btn-primary ml-2">수정</a>
      </common:Actions>
    </jsp:body>
  </layout:Page>
</t:layout>
