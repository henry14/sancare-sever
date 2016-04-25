<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>
<%@ taglib prefix="cssTags" tagdir="/WEB-INF/tags/css"%>

<!-- <h2>Regions!</h2> -->

<breadcrambTags:sancare-tag name="tip" />

<sysTags:addeditdeletebuttons url="tip" name="tip" />
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Health Tip</th>
				<th>Created by</th>
				<th>Created date</th>
				<th>Last modified by</th>
				<th>Last modified date</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty tips  && fn:length(tips) > 0}">
					<c:forEach var="tip" items="${tips}" varStatus="status">
						<tr id="${tip.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${tip.id }" /></td>
							<td>${tip.message}</td>
							<td>${tip.createdBy.username}</td>
							<td>${tip.createdDate}</td>
							<td>${tip.lastModifiedBy.username}</td>
							<td>${tip.lastModifiedDate}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<%-- 					<sysTags:no-items-found name="${nameOfItemOnPage}" numcol="9" /> --%>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>