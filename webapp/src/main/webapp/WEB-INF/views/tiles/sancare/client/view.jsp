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

<breadcrambTags:sancare-tag name="client" />

<sysTags:addeditdeletebuttons url="client" name="client" parentId="${client.id }" child1="beneficiary" child1Url="beneficiary" />
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Name</th>
				<th>Premium</th>
				<th>Created by</th>
				<th>Created date</th>
				<th>Last modified by</th>
				<th>Last modified date</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty clients  && fn:length(clients) > 0}">
					<c:forEach var="client" items="${clients}" varStatus="status">
						<tr id="${client.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${client.id }" /></td>
							<td>${client.name}</td>
							<td>${client.premium}</td>
							<td>${client.createdBy.username}</td>
							<td>${client.createdDate}</td>
							<td>${client.lastModifiedBy.username}</td>
							<td>${client.lastModifiedDate}</td>
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