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

<breadcrambTags:sancare-tag name="town" />

<sysTags:addeditdeletebuttons url="town" name="town" parentId="${town.id }" 
child1="hospital" child1Url="hospital" />
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Town</th>
				<th>Created by</th>
				<th>Created date</th>
				<th>Last modified by</th>
				<th>Last modified date</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty towns  && fn:length(towns) > 0}">
					<c:forEach var="town" items="${towns}" varStatus="status">
						<tr id="${town.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${town.id }" /></td>
							<td>${town.name}</td>
							<td>${town.createdBy.username}</td>
							<td>${town.createdDate}</td>
							<td>${town.lastModifiedBy.username}</td>
							<td>${town.lastModifiedDate}</td>
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