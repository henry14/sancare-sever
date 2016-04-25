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

<breadcrambTags:sancare-tag name="statement" />

<%-- <sysTags:addeditdeletebuttons url="statement" name="claim" /> --%>
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Company</th>
				<th>Cost</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty claims  && fn:length(claims) > 0}">
					<c:forEach var="claim" items="${claims}" varStatus="status">
						<tr id="${claim.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${claim.id }" /></td>
							<td>${claim.beneficiary.firstName}</td>
							<td>${claim.beneficiary.lastName}</td>
							<td>${claim.beneficiary.client.name}</td>
							<td>500000</td>
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