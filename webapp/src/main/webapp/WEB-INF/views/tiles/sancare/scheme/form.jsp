<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>

<breadcrambTags:sancare-tag name="policy" isForm="true" />

<div>
	<form:form action="${baseUrl }/policy/save" commandName="scheme"
		id="queryForm" cssClass="tabular">
		<form:hidden path="id" />
<%-- 		<form:hidden path="username" /> --%>
		<div class="box splitcontentleft">
			<%-- 		<form:errors path="*" cssClass="errorBox" /> --%>
			<p>
				<label class="uiLabel">Scheme</label>
				<form:input id="mName" path="name"
					cssClass="uiTextbox medium" />
			</p>
			
			<p>
				<label class="uiLabel">Description</label>
				<form:input id="mDescription" path="description"
					cssClass="uiTextarea large" />
			</p>
			
			<p style="clear: both;">
				<input id="btnSaveScheme" type="submit" value="Save"
					class="uiButton" />
			</p>
		</div>
	</form:form>
</div>