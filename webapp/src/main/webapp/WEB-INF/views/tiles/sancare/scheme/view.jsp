<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>
<%@ taglib prefix="cssTags" tagdir="/WEB-INF/tags/css"%>

<breadcrambTags:sancare-tag name="policy" />

<sysTags:addeditdeletebuttons url="policy" name="policy" />
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Scheme</th>
				<th>Description</th>
				<th>Created by</th>
				<th>Created date</th>
				<th>Last modified by</th>
				<th>Last modified date</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty schemes  && fn:length(schemes) > 0}">
					<c:forEach var="scheme" items="${schemes}" varStatus="status">
						<tr id="${scheme.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${scheme.id }" /></td>
							<td>${scheme.name}</td>
							<td>${scheme.description}</td>
							<td>${scheme.createdBy.username}</td>
							<td>${scheme.createdDate}</td>
							<td>${scheme.lastModifiedBy.username}</td>
							<td>${scheme.lastModifiedDate}</td>
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