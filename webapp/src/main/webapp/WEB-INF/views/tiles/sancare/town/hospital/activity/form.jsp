<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>

<breadcrambTags:sancare-tag name="service" isForm="true" />

<div>
	<form:form action="${baseUrl }/service/save" commandName="activity"
		id="activityForm" cssClass="tabular">
		<form:hidden path="id" />
		<form:hidden path="hospital" />
		<div class="box splitcontentleft">
			<%-- 		<form:errors path="*" cssClass="errorBox" /> --%>
			<p>
				<label class="uiLabel">Service</label>
				<form:input id="mAction" path="action"
					cssClass="uiTextbox medium" />
			</p>
			
			<p>
				<label class="uiLabel">Cost</label>
				<form:input id="mCost" path="cost"
					cssClass="uiTextbox medium" />
			</p>
			
			<p style="clear: both;">
				<input id="btnSaveActivity" type="submit" value="Save"
					class="uiButton" />
			</p>
		</div>
	</form:form>
</div>