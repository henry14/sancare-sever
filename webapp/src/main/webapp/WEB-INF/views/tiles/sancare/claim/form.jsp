<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>

<breadcrambTags:sancare-tag name="statement" isForm="true" />

<div>
	<%-- <form:form action="${baseUrl }/statement/save" commandName="claim"
		id="queryForm" cssClass="tabular">
		<form:hidden path="id" />
		<div class="box splitcontentleft">
		<p>
				<label class="uiLabel">Beneficiary</label>
				<form:select id="mddClient" path="beneficiary" cssClass="uiDropdown medium">
					<form:options itemLabel="first" itemValue="id" items="${beneficiary }" />
				</form:select>
			</p>
		<p>
				<label class="uiLabel">Service</label>
				<form:select id="mddActivity" path="activity" cssClass="uiDropdown medium">
					<form:options itemLabel="action" itemValue="id" items="${activitys }" />
				</form:select>
			</p>
			
			<p style="clear: both;">
				<input id="btnSaveActivity" type="submit" value="Save"
					class="uiButton" />
			</p>
		</div>
	</form:form> --%>
</div>