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

<breadcrambTags:sancare-tag name="beneficiary" />

<sysTags:addeditdeletebuttons url="beneficiary" name="beneficiary" parentId="${client.id }" />
<div id="records">
	<table class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Client</th>
				<th>Customer Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date Of Birth</th>
<!-- 				<th>Username</th> -->
<!-- 				<th>Password</th> -->
				<th>Principal</th>
				<th>Mobile user</th>
				<th>Created By</th>
				<th>Created date</th>
				<th>Last modified by</th>
				<th>Last modified date</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty beneficiaries  && fn:length(beneficiaries) > 0}">
					<c:forEach var="beneficiary" items="${beneficiaries}" varStatus="status">
						<tr id="${beneficiary.id }">
							<td><sysTags:rowcheckbox
									nameOfItemOnPage="${nameOfItemOnPage}" id="${beneficiary.id }" /></td>
							<td>${beneficiary.client.name}</td>
							<td>${beneficiary.memberNumber}</td>
							<td>${beneficiary.firstName}</td>
							<td>${beneficiary.lastName}</td>
							<td>${beneficiary.dateOfBirth}</td>
<%-- 							<td>${beneficiary.username}</td> --%>
<%-- 							<td>${beneficiary.password}</td> --%>
							<td>${beneficiary.principal}</td>
							<td>${beneficiary.mobile}</td>
							<td>${beneficiary.createdBy.username}</td>
							<td>${beneficiary.createdDate}</td>
							<td>${beneficiary.lastModifiedBy.username}</td>
							<td>${beneficiary.lastModifiedDate}</td>
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