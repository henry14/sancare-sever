<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<%@ taglib prefix="sysTags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="breadcrambTags"
	tagdir="/WEB-INF/tags/breadcrumblinks"%>

<breadcrambTags:sancare-tag name="user" isForm="true" />

<div>
	<form:form action="${baseUrl }/user/save" commandName="user"
		id="userForm" cssClass="tabular">
		<form:hidden path="id" />
		<div class="box splitcontentleft">
		 <%-- <p>
				<label class="uiLabel">First Name</label>
				<form:input id="mddFirstName" path="firstName" cssClass="uiTextbox medium"/>
			</p>
		<p>
				<label class="uiLabel">Last Name</label>
				<form:input id="mddLastName" path="lastName" cssClass="uiTextBox medium"/>
			</p>
			
			<p>
				<label class="uiLabel">Gender</label>
				<form:select id="mddGender" path="gender" cssClass="uiTextBox medium">
				<form:option value="Male" label="Male"/>
				<form:option value="Female" label="Female"/>
				</form:select>
			</p> --%>
			<p>
				<label class="uiLabel">First Name</label>
				<form:input id="mddLastName" path="firstName" cssClass="uiTextbox medium"/>
			</p>
			<p>
				<label class="uiLabel">Last Name</label>
				<form:input id="mddLastName" path="lastName" cssClass="uiTextbox medium"/>
			</p>
			
			<p>
				<label class="uiLabel">Username</label>
				<form:input id="mddUsername" path="username" cssClass="uiTextbox medium"/>
			</p>
			<p>
				<label class="uiLabel">Password</label>
				<form:input id="mddPassword" path="password" cssClass="uiTextBox medium"/>
			</p>
			
			<p>
				<label class="uiLabel">Role</label>
				<form:select id="mddRole" path="role" cssClass="uiDropDown medium">
					<form:options itemLabel="name" itemValue="id" items="${roles }" />
				</form:select>
			</p>
			
			
			<p>
				<label class="uiLabel">Salt</label>
				<form:input id="mddSalt" path="salt" cssClass="uiTextBox medium"/>
			</p>
			
			<p style="clear: both;">
				<input id="btnSaveActivity" type="submit" value="Save"
					class="uiButton" />
			</p>
		</div>
	</form:form>
</div>