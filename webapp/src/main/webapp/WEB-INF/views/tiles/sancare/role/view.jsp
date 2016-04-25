<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags" tagdir="/WEB-INF/tags/breadcramblinks"%>

<breadcrambTags:settings name="roles" />

<sysTags:name-of-item-on-page name="Role" />

<div>
	<div id="buttonStrip" class="group buttonStrip">
		<sysTags:addeditdeletebuttons url="role" name="${nameOfItemOnPage}" />

		<div style="float: right;">
			<%@ include file="/WEB-INF/views/navigation.jsp"%>
		</div>
		<div style="clear: both;"></div>
	</div>

	<table id="recordTable" class="recordTable">
		<thead>
			<tr>
				<th><input type="checkbox" id="cbxSelectAllItems" /></th>
				<th>Name</th>
				<th>Description</th>
				<th>Permissions</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty roles  && fn:length(roles) > 0}">
					<c:forEach var="role" items="${roles }" varStatus="status">
						<tr id="${role.id }">
							<td>
								<sysTags:rowcheckbox nameOfItemOnPage="${nameOfItemOnPage}" id="${role.id }" />
								${status.count }
							</td>
							<td>${role.name }</td>
							<td>${role.description }</td>
							<td>${role.permissionsString }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>