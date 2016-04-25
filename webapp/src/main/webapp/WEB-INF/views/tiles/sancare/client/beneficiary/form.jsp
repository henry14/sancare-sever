<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>

<breadcrambTags:sancare-tag name="beneficiary" isForm="true" />

<div>
	<form:form action="${baseUrl }/beneficiary/save" commandName="beneficiary" id="queryForm" 
	cssClass="tabular">
		<form:hidden path="id" />
		<form:hidden path="client" />
		<div class="box splitcontentleft">
			<%-- 		<form:errors path="*" cssClass="errorBox" /> --%>
			<p>
<%-- 			Add a class attribute that stops a user from continuing if they have input a string --%>
<%--                Check if field has an integer before saving --%>
				<label class="uiLabel">Member number</label>
				<form:input id="mMemberNumber" path="memberNumber"	cssClass="uiTextbox medium" />
			</p>
			<p>
				<label class="uiLabel">First name</label>
				<form:input id="mFirstName" path="firstName" cssClass="uiTextbox medium" />
			</p>
			<p>
				<label class="uiLabel">Last name</label>
				<form:input id="mLastName" path="lastName" cssClass="uiTextbox medium" />
			</p>
			<p>
				<label class="uiLabel">Date of birth</label>
				<form:input id="mDateOfBirth" path="dateOfBirth" cssClass="uiTextbox medium uiDateTextbox" />
			</p>
			<p>
				<label class="uiLabel">Principal</label>
				<form:select id="mddPrincipal" path="principal" cssClass="uiDropdown medium">
<%-- 					<form:options> --%>
						<form:option value="false">False</form:option>
						<form:option value="true">True</form:option>
<%-- 					</form:options> --%>
				</form:select>
			</p>
			
			<p style="clear: both;">
				<input id="btnSaveBeneficiary" type="submit" value="Save" class="uiButton" />
			</p>
		</div>
	</form:form>
</div>